# T-Mobile Interview Prep - Part 4: System Design & Behavioral Questions

## System Design - Complete Solutions

### 1. Design URL Shortener (like bit.ly)

**Requirements:**
- Shorten long URLs to short codes
- Redirect short URLs to original URLs
- Track analytics (clicks, geography, devices)
- High availability, low latency
- Handle 100M URLs, 10K requests/second

**Solution:**

```
┌─────────────┐
│   Client    │
└──────┬──────┘
       │
       ▼
┌─────────────────┐
│  Load Balancer  │
└────────┬────────┘
         │
    ┌────┴────┐
    ▼         ▼
┌────────┐ ┌────────┐
│  API   │ │  API   │
│Gateway │ │Gateway │
└───┬────┘ └───┬────┘
    │          │
    └────┬─────┘
         ▼
┌──────────────────┐
│ URL Shortening   │
│    Service       │
└────┬─────────────┘
     │
     ├──────────────┐
     ▼              ▼
┌─────────┐    ┌─────────┐
│  Redis  │    │Database │
│  Cache  │    │(NoSQL)  │
└─────────┘    └─────────┘
     │              │
     └──────┬───────┘
            ▼
     ┌──────────────┐
     │   Kafka      │
     │   Queue      │
     └──────┬───────┘
            ▼
     ┌──────────────┐
     │  Analytics   │
     │   Service    │
     └──────────────┘
```

**API Design:**

```java
// 1. Shorten URL
POST /api/v1/shorten
Request:
{
  "longUrl": "https://www.example.com/very/long/url/path",
  "customAlias": "mylink",  // optional
  "expiresAt": "2025-12-31T23:59:59Z"  // optional
}

Response:
{
  "shortUrl": "https://short.ly/abc123",
  "shortCode": "abc123",
  "longUrl": "https://www.example.com/very/long/url/path",
  "createdAt": "2025-01-15T10:30:00Z",
  "expiresAt": "2025-12-31T23:59:59Z"
}

// 2. Redirect
GET /{shortCode}
Response: 302 Redirect to long URL

// 3. Get Analytics
GET /api/v1/analytics/{shortCode}
Response:
{
  "shortCode": "abc123",
  "totalClicks": 1523,
  "clicksByDate": [...],
  "clicksByCountry": {...},
  "clicksByDevice": {...}
}
```

**Database Schema:**

```sql
-- URLs Table (Cassandra/DynamoDB)
CREATE TABLE urls (
    short_code VARCHAR(10) PRIMARY KEY,
    long_url TEXT NOT NULL,
    user_id BIGINT,
    created_at TIMESTAMP,
    expires_at TIMESTAMP,
    is_active BOOLEAN DEFAULT true,
    INDEX idx_user_id (user_id)
);

-- Analytics Table (Time-series DB like InfluxDB)
CREATE TABLE analytics (
    id BIGINT PRIMARY KEY,
    short_code VARCHAR(10),
    timestamp TIMESTAMP,
    ip_address VARCHAR(45),
    country VARCHAR(2),
    city VARCHAR(100),
    device_type VARCHAR(20),
    browser VARCHAR(50),
    referrer TEXT,
    INDEX idx_short_code_timestamp (short_code, timestamp)
);
```

**Implementation:**

```java
@Service
@Slf4j
public class UrlShortenerService {
    
    private final UrlRepository urlRepository;
    private final RedisTemplate<String, String> redisTemplate;
    private final KafkaTemplate<String, ClickEvent> kafkaTemplate;
    private final IdGenerator idGenerator;
    
    private static final String BASE62_CHARS = 
        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    
    // Shorten URL
    @Transactional
    public ShortenResponse shortenUrl(ShortenRequest request) {
        // Check if custom alias is available
        if (request.getCustomAlias() != null) {
            if (urlRepository.existsByShortCode(request.getCustomAlias())) {
                throw new BadRequestException("Custom alias already taken");
            }
            return createShortUrl(request.getLongUrl(), request.getCustomAlias());
        }
        
        // Generate unique short code
        String shortCode = generateShortCode();
        return createShortUrl(request.getLongUrl(), shortCode);
    }
    
    private String generateShortCode() {
        // Get unique ID from distributed ID generator (Snowflake/Twitter)
        long id = idGenerator.nextId();
        
        // Convert to Base62
        return toBase62(id);
    }
    
    private String toBase62(long num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(BASE62_CHARS.charAt((int)(num % 62)));
            num /= 62;
        }
        
        return sb.reverse().toString();
    }
    
    private ShortenResponse createShortUrl(String longUrl, String shortCode) {
        Url url = new Url();
        url.setShortCode(shortCode);
        url.setLongUrl(longUrl);
        url.setCreatedAt(LocalDateTime.now());
        url.setActive(true);
        
        urlRepository.save(url);
        
        // Cache in Redis (TTL: 24 hours)
        redisTemplate.opsForValue().set(
            "url:" + shortCode, 
            longUrl, 
            24, 
            TimeUnit.HOURS
        );
        
        return new ShortenResponse(
            "https://short.ly/" + shortCode,
            shortCode,
            longUrl,
            url.getCreatedAt()
        );
    }
    
    // Redirect
    public String getLongUrl(String shortCode, HttpServletRequest request) {
        // Check cache first
        String longUrl = redisTemplate.opsForValue().get("url:" + shortCode);
        
        if (longUrl == null) {
            // Cache miss - fetch from DB
            Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new ResourceNotFoundException("URL not found"));
            
            if (!url.isActive() || isExpired(url)) {
                throw new ResourceNotFoundException("URL expired or inactive");
            }
            
            longUrl = url.getLongUrl();
            
            // Update cache
            redisTemplate.opsForValue().set(
                "url:" + shortCode, 
                longUrl, 
                24, 
                TimeUnit.HOURS
            );
        }
        
        // Publish click event asynchronously
        publishClickEvent(shortCode, request);
        
        return longUrl;
    }
    
    private void publishClickEvent(String shortCode, HttpServletRequest request) {
        ClickEvent event = new ClickEvent(
            shortCode,
            LocalDateTime.now(),
            request.getRemoteAddr(),
            request.getHeader("User-Agent"),
            request.getHeader("Referer")
        );
        
        kafkaTemplate.send("click-events", event);
    }
    
    private boolean isExpired(Url url) {
        return url.getExpiresAt() != null && 
               url.getExpiresAt().isBefore(LocalDateTime.now());
    }
}

// Analytics Service (Separate Microservice)
@Service
@Slf4j
public class AnalyticsService {
    
    private final AnalyticsRepository analyticsRepository;
    
    @KafkaListener(topics = "click-events", groupId = "analytics-service")
    public void handleClickEvent(ClickEvent event) {
        Analytics analytics = new Analytics();
        analytics.setShortCode(event.getShortCode());
        analytics.setTimestamp(event.getTimestamp());
        analytics.setIpAddress(event.getIpAddress());
        
        // Parse user agent
        UserAgent ua = UserAgent.parseUserAgentString(event.getUserAgent());
        analytics.setDeviceType(ua.getOperatingSystem().getDeviceType().getName());
        analytics.setBrowser(ua.getBrowser().getName());
        
        // Get geolocation from IP
        GeoLocation geo = geoLocationService.getLocation(event.getIpAddress());
        analytics.setCountry(geo.getCountry());
        analytics.setCity(geo.getCity());
        
        analytics.setReferrer(event.getReferrer());
        
        analyticsRepository.save(analytics);
        log.info("Analytics saved for short code: {}", event.getShortCode());
    }
    
    public AnalyticsResponse getAnalytics(String shortCode) {
        List<Analytics> data = analyticsRepository.findByShortCode(shortCode);
        
        return AnalyticsResponse.builder()
            .shortCode(shortCode)
            .totalClicks(data.size())
            .clicksByDate(groupByDate(data))
            .clicksByCountry(groupByCountry(data))
            .clicksByDevice(groupByDevice(data))
            .build();
    }
}
```

**Scalability Considerations:**

1. **Database Sharding:** Shard by hash of short_code
2. **Caching:** Redis for hot URLs (80-20 rule)
3. **CDN:** Serve static content and redirect pages
4. **Rate Limiting:** Prevent abuse (per IP, per user)
5. **Monitoring:** Track latency, error rates, cache hit ratio

**Capacity Estimation:**

```
Storage:
- 100M URLs
- Average URL size: 500 bytes
- Total: 100M * 500 bytes = 50 GB

Bandwidth:
- 10K reads/sec
- Average response: 1 KB
- Bandwidth: 10K * 1 KB = 10 MB/sec

Cache:
- 20% hot URLs = 20M URLs
- Cache size: 20M * 500 bytes = 10 GB
```

---

### 2. Design Notification System

**Requirements:**
- Send notifications via Email, SMS, Push
- Support millions of users
- Priority levels (urgent, normal, low)
- Retry mechanism for failures
- User preferences (opt-in/opt-out)
- Template management

**Solution:**

```
┌──────────────┐
│   Services   │
│ (Order, User)│
└──────┬───────┘
       │
       ▼
┌──────────────────┐
│ Notification API │
└────────┬─────────┘
         │
         ▼
┌──────────────────┐
│  Message Queue   │
│     (Kafka)      │
└────────┬─────────┘
         │
    ┌────┴────┬────────┬────────┐
    ▼         ▼        ▼        ▼
┌────────┐ ┌──────┐ ┌──────┐ ┌──────┐
│ Email  │ │ SMS  │ │ Push │ │ ...  │
│Worker  │ │Worker│ │Worker│ │      │
└───┬────┘ └──┬───┘ └──┬───┘ └──────┘
    │         │        │
    ▼         ▼        ▼
┌────────┐ ┌──────┐ ┌──────┐
│SendGrid│ │Twilio│ │ FCM  │
└────────┘ └──────┘ └──────┘
```

**Implementation:**

```java
// 1. Notification Request
@Data
public class NotificationRequest {
    private String userId;
    private NotificationType type;  // EMAIL, SMS, PUSH
    private Priority priority;      // URGENT, NORMAL, LOW
    private String templateId;
    private Map<String, Object> data;
    private LocalDateTime scheduledAt;
}

// 2. Notification Service
@Service
@Slf4j
public class NotificationService {
    
    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;
    private final UserPreferenceService userPreferenceService;
    private final TemplateService templateService;
    
    public void sendNotification(NotificationRequest request) {
        // Check user preferences
        UserPreference pref = userPreferenceService.getPreference(request.getUserId());
        
        if (!pref.isEnabled(request.getType())) {
            log.info("User {} has disabled {} notifications", 
                request.getUserId(), request.getType());
            return;
        }
        
        // Create notification event
        NotificationEvent event = NotificationEvent.builder()
            .id(UUID.randomUUID().toString())
            .userId(request.getUserId())
            .type(request.getType())
            .priority(request.getPriority())
            .templateId(request.getTemplateId())
            .data(request.getData())
            .createdAt(LocalDateTime.now())
            .status(NotificationStatus.PENDING)
            .build();
        
        // Publish to appropriate topic based on priority
        String topic = getTopicByPriority(request.getPriority());
        kafkaTemplate.send(topic, event);
        
        log.info("Notification event published: {}", event.getId());
    }
    
    private String getTopicByPriority(Priority priority) {
        return switch (priority) {
            case URGENT -> "notifications-urgent";
            case NORMAL -> "notifications-normal";
            case LOW -> "notifications-low";
        };
    }
}

// 3. Email Worker
@Service
@Slf4j
public class EmailWorker {
    
    private final JavaMailSender mailSender;
    private final TemplateService templateService;
    private final NotificationRepository notificationRepository;
    
    @KafkaListener(
        topics = {"notifications-urgent", "notifications-normal", "notifications-low"},
        groupId = "email-worker",
        concurrency = "3"
    )
    @Retryable(
        value = {MailException.class},
        maxAttempts = 3,
        backoff = @Backoff(delay = 5000, multiplier = 2)
    )
    public void processEmailNotification(NotificationEvent event) {
        if (event.getType() != NotificationType.EMAIL) {
            return;
        }
        
        try {
            // Get template
            Template template = templateService.getTemplate(event.getTemplateId());
            
            // Render template with data
            String subject = templateService.render(template.getSubject(), event.getData());
            String body = templateService.render(template.getBody(), event.getData());
            
            // Send email
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            
            helper.setTo(event.getUserEmail());
            helper.setSubject(subject);
            helper.setText(body, true);  // HTML
            
            mailSender.send(message);
            
            // Update status
            updateNotificationStatus(event.getId(), NotificationStatus.SENT);
            
            log.info("Email sent successfully: {}", event.getId());
            
        } catch (Exception e) {
            log.error("Failed to send email: {}", event.getId(), e);
            updateNotificationStatus(event.getId(), NotificationStatus.FAILED);
            throw new RuntimeException("Email sending failed", e);
        }
    }
    
    @Recover
    public void recover(MailException e, NotificationEvent event) {
        log.error("All retry attempts exhausted for notification: {}", event.getId());
        updateNotificationStatus(event.getId(), NotificationStatus.FAILED);
        // Send to DLQ for manual intervention
    }
    
    private void updateNotificationStatus(String id, NotificationStatus status) {
        // Update in database
        notificationRepository.updateStatus(id, status);
    }
}

// 4. SMS Worker
@Service
@Slf4j
public class SmsWorker {
    
    private final TwilioClient twilioClient;
    private final TemplateService templateService;
    
    @KafkaListener(
        topics = {"notifications-urgent", "notifications-normal"},
        groupId = "sms-worker"
    )
    public void processSmsNotification(NotificationEvent event) {
        if (event.getType() != NotificationType.SMS) {
            return;
        }
        
        try {
            Template template = templateService.getTemplate(event.getTemplateId());
            String message = templateService.render(template.getBody(), event.getData());
            
            // Send SMS via Twilio
            twilioClient.sendSms(event.getUserPhone(), message);
            
            updateNotificationStatus(event.getId(), NotificationStatus.SENT);
            log.info("SMS sent successfully: {}", event.getId());
            
        } catch (Exception e) {
            log.error("Failed to send SMS: {}", event.getId(), e);
            updateNotificationStatus(event.getId(), NotificationStatus.FAILED);
        }
    }
}

// 5. Push Notification Worker
@Service
@Slf4j
public class PushNotificationWorker {
    
    private final FirebaseMessaging firebaseMessaging;
    
    @KafkaListener(
        topics = {"notifications-urgent", "notifications-normal"},
        groupId = "push-worker"
    )
    public void processPushNotification(NotificationEvent event) {
        if (event.getType() != NotificationType.PUSH) {
            return;
        }
        
        try {
            Message message = Message.builder()
                .setToken(event.getDeviceToken())
                .setNotification(Notification.builder()
                    .setTitle(event.getData().get("title").toString())
                    .setBody(event.getData().get("body").toString())
                    .build())
                .build();
            
            String response = firebaseMessaging.send(message);
            
            updateNotificationStatus(event.getId(), NotificationStatus.SENT);
            log.info("Push notification sent: {}", response);
            
        } catch (Exception e) {
            log.error("Failed to send push notification: {}", event.getId(), e);
            updateNotificationStatus(event.getId(), NotificationStatus.FAILED);
        }
    }
}
```

---

## Behavioral Questions - STAR Method Answers

### 1. Tell me about a challenging bug you fixed

**Situation:**
In my previous project, we had a critical production issue where our microservice was experiencing intermittent Kafka consumer lag, causing delays of up to 2 hours in order processing.

**Task:**
I was assigned to investigate and resolve the issue as it was impacting customer experience and SLA commitments.

**Action:**
1. Analyzed Kafka consumer metrics and found that consumer rebalancing was happening frequently
2. Reviewed application logs and discovered that some messages were taking too long to process
3. Identified that database queries in the message handler were not optimized
4. Added database indexes on frequently queried columns
5. Implemented batch processing instead of processing messages one by one
6. Increased the number of consumer threads from 3 to 10
7. Added circuit breakers to prevent cascading failures
8. Implemented proper error handling and DLQ for failed messages

**Result:**
- Reduced consumer lag from 2 hours to under 5 minutes
- Improved message processing throughput by 300%
- Eliminated consumer rebalancing issues
- Received appreciation from the team and stakeholders

---

### 2. Describe a time you improved system performance

**Situation:**
Our REST API for fetching user orders was experiencing high latency (avg 2 seconds) during peak hours, affecting user experience.

**Task:**
Optimize the API to achieve sub-500ms response time.

**Action:**
1. Profiled the application using JProfiler and identified N+1 query problem
2. Implemented JPA fetch joins to reduce database round trips
3. Added Redis caching for frequently accessed data
4. Implemented database connection pooling with HikariCP
5. Added database indexes on foreign keys
6. Implemented pagination to limit result set size
7. Used CompletableFuture for parallel processing of independent operations

**Result:**
- Reduced average response time from 2 seconds to 300ms (85% improvement)
- Reduced database queries from 50+ to 3 per request
- Cache hit ratio of 70% for hot data
- Improved system throughput from 100 to 500 requests/second

---


