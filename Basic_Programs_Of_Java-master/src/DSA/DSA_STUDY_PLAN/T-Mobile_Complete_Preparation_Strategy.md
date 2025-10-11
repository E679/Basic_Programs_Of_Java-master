# 🎯 T-Mobile Backend Developer Interview Preparation Strategy

## Complete Guide for All 4 Technical Rounds

---

## 📋 Table of Contents

1. [Round 1: DSA (Data Structures & Algorithms)](#round-1-dsa)
2. [Round 2: Java & Spring Boot Deep Dive](#round-2-java-spring-boot)
3. [Round 3: Microservices & Cloud (AWS/Kubernetes)](#round-3-microservices-cloud)
4. [Round 4: System Design](#round-4-system-design)
5. [Behavioral Questions (STAR Method)](#behavioral-questions)
6. [Quick Reference Cheat Sheet](#quick-reference-cheat-sheet)
7. [Final Tips](#final-tips)

---

## Round 1: DSA (Data Structures & Algorithms) - 45-60 mins {#round-1-dsa}

### 🎯 Focus Areas

#### 1. Core Data Structures (Must Know)

- **Arrays & Strings** (sliding window, two pointers)
- **LinkedList** (reversal, cycle detection, merge)
- **Stacks & Queues** (monotonic stack, deque)
- **HashMap & HashSet** (frequency counting, grouping)
- **Trees** (BST, Binary Tree traversals - inorder, preorder, postorder, level order)
- **Graphs** (BFS, DFS, topological sort)
- **Heaps** (min/max heap, priority queue)

#### 2. Key Algorithms

- **Sorting:** QuickSort, MergeSort, HeapSort
- **Searching:** Binary Search & variations
- **Recursion & Backtracking**
- **Dynamic Programming** (1D & 2D DP)
- **Greedy Algorithms**
- **Sliding Window**
- **Two Pointers**

#### 3. Common Problem Patterns (Practice These)

##### Arrays:
- Two Sum, Three Sum
- Maximum Subarray (Kadane's Algorithm)
- Merge Intervals
- Product of Array Except Self
- Rotate Array

##### Strings:
- Longest Substring Without Repeating Characters
- Valid Anagram
- Group Anagrams
- Longest Palindromic Substring

##### LinkedList:
- Reverse LinkedList
- Detect Cycle
- Merge Two Sorted Lists
- Remove Nth Node From End

##### Trees:
- Maximum Depth of Binary Tree
- Validate BST
- Lowest Common Ancestor
- Binary Tree Level Order Traversal
- Serialize and Deserialize Binary Tree

##### Graphs:
- Number of Islands
- Course Schedule (Topological Sort)
- Clone Graph
- Word Ladder

##### Dynamic Programming:
- Climbing Stairs
- Coin Change
- Longest Increasing Subsequence
- House Robber

### 📚 Practice Plan (Today)

- ✅ Solve 10-15 medium problems on LeetCode
- ✅ Focus on: Arrays, Strings, Trees, HashMap
- ✅ Practice explaining your approach out loud

---

## Round 2: Java & Spring Boot Deep Dive - 60 mins {#round-2-java-spring-boot}

### ☕ Java Core Concepts

#### 1. OOP Principles

- **Encapsulation, Inheritance, Polymorphism, Abstraction**
- **SOLID principles** (especially Single Responsibility, Dependency Inversion)
- **Design patterns:** Singleton, Factory, Builder, Strategy, Observer

#### 2. Java 8+ Features

- Lambda expressions & Functional interfaces
- Stream API (map, filter, reduce, collect)
- Optional class
- CompletableFuture for async programming
- Method references

#### 3. Collections Framework

- ArrayList vs LinkedList
- HashMap internals (hashing, collision handling, load factor)
- ConcurrentHashMap vs HashMap
- TreeMap vs HashMap
- When to use which collection

#### 4. Multithreading & Concurrency

- Thread lifecycle
- Synchronization, volatile, atomic variables
- ExecutorService, ThreadPool
- CountDownLatch, CyclicBarrier, Semaphore
- Deadlock, race conditions

#### 5. Memory Management

- Heap vs Stack
- Garbage Collection (G1GC, ZGC)
- Memory leaks and how to prevent them
- JVM tuning parameters

### 🍃 Spring Boot Deep Dive

#### 1. Core Concepts

```java
// Dependency Injection
@Autowired vs @Inject vs Constructor Injection (preferred)

// Bean Scopes
@Scope("singleton") // default
@Scope("prototype")
@Scope("request")
@Scope("session")

// Configuration
@Configuration
@Bean
@ComponentScan
@PropertySource
```

#### 2. REST API Development

```java
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // Implementation
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO dto) {
        // Implementation
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
        @PathVariable Long id, 
        @RequestBody UserDTO dto) {
        // Implementation
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Implementation
    }
}
```

#### 3. Exception Handling

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
        ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse(ex.getMessage()));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
        MethodArgumentNotValidException ex) {
        // Handle validation errors
    }
}
```

#### 4. Spring Boot Annotations

```java
@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
@Service, @Repository, @Component
@Transactional (propagation, isolation levels)
@Async, @Scheduled
@Cacheable, @CacheEvict
```

#### 5. Application Properties & Profiles

```yaml
spring:
  profiles:
    active: dev
  datasource:
    url: jdbc:postgresql://localhost:5432/mydb
    username: ${DB_USER}
    password: ${DB_PASSWORD}
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false
```

---

## Round 3: Microservices & Cloud (AWS/Kubernetes) - 60 mins {#round-3-microservices-cloud}

### 🏗️ Microservices Architecture

#### 1. Core Principles

- Single Responsibility
- Loose Coupling, High Cohesion
- Independent Deployment
- Database per Service
- API Gateway pattern
- Service Discovery

#### 2. Communication Patterns

**Synchronous - REST:**

```java
@FeignClient(name = "user-service")
public interface UserServiceClient {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id);
}
```

**Asynchronous - Kafka:**

```java
@Service
public class OrderEventProducer {
    
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;
    
    public void publishOrderCreated(OrderEvent event) {
        kafkaTemplate.send("order-created-topic", event);
    }
}

@KafkaListener(topics = "order-created-topic", groupId = "inventory-service")
public void handleOrderCreated(OrderEvent event) {
    // Process event
}
```

#### 3. Resilience Patterns

```java
// Circuit Breaker with Resilience4j
@CircuitBreaker(name = "userService", fallbackMethod = "getUserFallback")
public User getUser(Long id) {
    return userServiceClient.getUserById(id);
}

public User getUserFallback(Long id, Exception ex) {
    return new User(id, "Default User");
}

// Retry
@Retry(name = "userService", fallbackMethod = "getUserFallback")
public User getUserWithRetry(Long id) {
    return userServiceClient.getUserById(id);
}

// Rate Limiter
@RateLimiter(name = "userService")
public User getUserRateLimited(Long id) {
    return userServiceClient.getUserById(id);
}
```

#### 3. Service YAML

```yaml
apiVersion: v1
kind: Service
metadata:
  name: user-service
spec:
  type: LoadBalancer
  selector:
    app: user-service
  ports:
  - protocol: TCP
    port: 80
    targetPort: 8080
```

### ☁️ AWS Services

#### 1. Core Services You Should Know

- **EC2:** Virtual servers, instance types, security groups
- **S3:** Object storage, bucket policies, versioning
- **RDS:** Managed databases (PostgreSQL, MySQL)
- **Lambda:** Serverless functions
- **API Gateway:** REST API management
- **SQS:** Message queuing
- **SNS:** Pub/Sub messaging
- **CloudWatch:** Monitoring & logging
- **IAM:** Identity & Access Management
- **VPC:** Virtual Private Cloud, subnets, route tables
- **ECS/EKS:** Container orchestration

#### 2. Common Scenarios

**S3 Upload:**

```java
@Service
public class S3Service {

    @Autowired
    private AmazonS3 s3Client;

    public String uploadFile(MultipartFile file) {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        s3Client.putObject(
            "my-bucket",
            fileName,
            file.getInputStream(),
            metadata
        );

        return s3Client.getUrl("my-bucket", fileName).toString();
    }
}
```

**SQS Message Publishing:**

```java
@Service
public class SQSService {

    @Autowired
    private AmazonSQS sqsClient;

    public void sendMessage(String message) {
        SendMessageRequest request = new SendMessageRequest()
            .withQueueUrl("https://sqs.us-east-1.amazonaws.com/123456/my-queue")
            .withMessageBody(message);

        sqsClient.sendMessage(request);
    }
}
```

---

## Round 4: System Design - 60-90 mins {#round-4-system-design}

### 🏛️ Common System Design Questions

#### 1. Design a URL Shortener (like bit.ly)

**Requirements:**
- Shorten long URLs
- Redirect to original URL
- Track analytics (clicks, geography)
- High availability, low latency

**Solution Approach:**

**Components:**
1. API Gateway
2. URL Shortening Service
3. Database (NoSQL - DynamoDB/Cassandra)
4. Cache (Redis)
5. Analytics Service
6. Message Queue (Kafka)

**Flow:**
1. User submits long URL
2. Generate short code (Base62 encoding of auto-increment ID)
3. Store mapping in DB
4. Cache frequently accessed URLs
5. On redirect, check cache first, then DB
6. Publish click event to Kafka for analytics

**Database Schema:**
```sql
-- url_mappings
{short_code, long_url, user_id, created_at, expires_at}

-- analytics
{short_code, timestamp, ip, country, device}
```

**Scalability:**
- Horizontal scaling of services
- Database sharding by short_code hash
- CDN for static content
- Rate limiting per user

---

#### 2. Design a Notification System

**Requirements:**
- Send notifications via Email, SMS, Push
- Support millions of users
- Prioritization (urgent vs normal)
- Retry mechanism for failures

**Solution:**

**Components:**
1. Notification API Service
2. Message Queue (Kafka/SQS)
3. Worker Services (Email, SMS, Push)
4. Template Service
5. User Preference Service
6. Delivery Status Tracker

**Flow:**
1. Service publishes notification event to queue
2. Workers consume based on channel (email/sms/push)
3. Check user preferences
4. Render template
5. Send via provider (SendGrid, Twilio, FCM)
6. Update delivery status
7. Retry on failure with exponential backoff

**Database:**
```sql
-- notifications
{id, user_id, type, status, created_at}

-- user_preferences
{user_id, email_enabled, sms_enabled}

-- templates
{id, type, subject, body}
```

**Scalability:**
- Partition queue by priority
- Multiple worker instances
- Rate limiting per provider
- Dead letter queue for failed messages

---

#### 3. Design an E-commerce Order Management System

**Microservices:**
1. User Service
2. Product Catalog Service
3. Inventory Service
4. Order Service
5. Payment Service
6. Notification Service
7. Shipping Service

**Event Flow (Saga Pattern):**
1. User places order → Order Service
2. Order Service publishes OrderCreated event
3. Inventory Service reserves items
4. Payment Service processes payment
5. If payment succeeds → Shipping Service creates shipment
6. If payment fails → Inventory Service releases reservation
7. Notification Service sends updates at each step

**Database per Service:**
- **Order DB:** PostgreSQL (ACID transactions)
- **Inventory DB:** PostgreSQL
- **Product Catalog:** MongoDB (read-heavy)
- **User DB:** PostgreSQL

**Communication:**
- **Synchronous:** REST for read operations
- **Asynchronous:** Kafka for events
- **API Gateway** for external clients

**Resilience:**
- Circuit breakers between services
- Retry with exponential backoff
- Compensating transactions for rollback
- Distributed tracing with Sleuth/Zipkin

---

### 📐 System Design Framework (Use This)

#### 1. Requirements Clarification (5 mins)
- Functional requirements
- Non-functional requirements (scale, latency, availability)
- Constraints

#### 2. Capacity Estimation (5 mins)
- Users, requests per second
- Storage requirements
- Bandwidth

#### 3. High-Level Design (10 mins)
- Draw architecture diagram
- Identify major components
- Data flow

#### 4. Deep Dive (20-30 mins)
- Database schema
- API design
- Scalability considerations
- Caching strategy
- Load balancing

#### 5. Trade-offs & Bottlenecks (10 mins)
- Discuss alternatives
- Identify potential issues
- How to monitor and debug

---

## 🎤 Behavioral Questions (STAR Method) {#behavioral-questions}

### 1. Tell me about a challenging bug you fixed

**Situation:** Production issue with Kafka consumer lag

**Task:** Reduce lag and prevent future occurrences

**Action:**
- Analyzed consumer metrics
- Increased partitions
- Optimized processing logic
- Added monitoring alerts

**Result:** Reduced lag from 2 hours to 5 minutes

---

### 2. Describe a time you improved system performance

**Use examples from your current work:**
- Mention specific metrics (latency reduced by X%, throughput increased by Y%)
- Explain the problem, your solution, and the impact

---

### 3. How do you handle disagreements with team members?

- Focus on collaboration and data-driven decisions
- Show respect for different perspectives
- Emphasize team goals over individual preferences

---

### 4. Tell me about a time you learned a new technology quickly

- Mention Kubernetes, Kafka, or any recent tech you picked up
- Explain your learning approach
- Show the practical application

---

## 📝 Quick Reference Cheat Sheet {#quick-reference-cheat-sheet}

### Time Complexity

```
O(1)      - HashMap get/put
O(log n)  - Binary search, TreeMap operations
O(n)      - Linear search, array traversal
O(n log n)- Merge sort, heap sort
O(n²)     - Nested loops, bubble sort
```

### Spring Boot Starter Dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

### HTTP Status Codes

```
200 OK                    - Success
201 Created               - Resource created
204 No Content            - Success with no response body
400 Bad Request           - Invalid input
401 Unauthorized          - Authentication required
403 Forbidden             - No permission
404 Not Found             - Resource doesn't exist
409 Conflict              - Duplicate resource
500 Internal Server Error - Server error
503 Service Unavailable   - Service down
```

---

## 🔥 Key Topics to Revise Tonight

### Must Know:

- ✅ HashMap internals & collision handling
- ✅ Spring Boot annotations & lifecycle
- ✅ REST API best practices (idempotency, versioning)
- ✅ Kafka consumer groups & offset management
- ✅ Kubernetes pods, deployments, services
- ✅ Circuit breaker pattern
- ✅ Database indexing & query optimization
- ✅ Microservices communication patterns
- ✅ CAP theorem
- ✅ SOLID principles with examples

---

## 💡 Final Tips {#final-tips}

### For DSA Round:
- ✅ Think out loud
- ✅ Start with brute force, then optimize
- ✅ Discuss time & space complexity
- ✅ Write clean, compilable code
- ✅ Test with edge cases

### For Technical Rounds:
- ✅ Use real examples from your projects
- ✅ Mention specific numbers (improved latency by 40%)
- ✅ Discuss trade-offs
- ✅ Show you understand production concerns

### For System Design:
- ✅ Ask clarifying questions
- ✅ Start simple, then scale
- ✅ Draw diagrams
- ✅ Discuss monitoring & alerting
- ✅ Mention failure scenarios

### General:
- ✅ Be confident but humble
- ✅ Say "I don't know, but here's how I'd find out" if stuck
- ✅ Show enthusiasm for learning
- ✅ Ask good questions at the end

---

## 🎯 Good Luck with Your Interview!

**Remember:** You have 4.3 years of solid experience with Java, Spring Boot, Microservices, AWS, Kafka, Kubernetes, and Splunk. You've got this! 💪

**Stay calm, think clearly, and showcase your expertise!** 🚀

#### 4. Distributed Tracing & Monitoring

- Spring Cloud Sleuth for distributed tracing
- Zipkin/Jaeger for trace visualization
- Micrometer for metrics
- Splunk for log aggregation

### 📨 Kafka Deep Dive

#### 1. Core Concepts

- Topics, Partitions, Offsets
- Producers, Consumers, Consumer Groups
- Replication Factor, ISR (In-Sync Replicas)
- Exactly-once semantics
- Idempotent producers

#### 2. Configuration

```java
@Configuration
public class KafkaConfig {
    
    @Bean
    public ProducerFactory<String, OrderEvent> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.ACKS_CONFIG, "all");
        config.put(ProducerConfig.RETRIES_CONFIG, 3);
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        return new DefaultKafkaProducerFactory<>(config);
    }
    
    @Bean
    public ConsumerFactory<String, OrderEvent> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "order-service");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        return new DefaultKafkaConsumerFactory<>(config);
    }
}
```

#### 3. Common Interview Questions

- ❓ How do you ensure message ordering in Kafka?
- ❓ What happens if a consumer fails?
- ❓ How do you handle duplicate messages?
- ❓ Explain consumer rebalancing
- ❓ When to use Kafka vs RabbitMQ?

### ☸️ Kubernetes

#### 1. Core Concepts

- Pods, Deployments, Services, ConfigMaps, Secrets
- ReplicaSets, StatefulSets, DaemonSets
- Ingress, LoadBalancer
- Namespaces, Resource Quotas
- Liveness & Readiness Probes

#### 2. Deployment YAML

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: user-service
spec:
  replicas: 3
  selector:
    matchLabels:
      app: user-service
  template:
    metadata:
      labels:
        app: user-service
    spec:
      containers:
      - name: user-service
        image: user-service:1.0.0
        ports:
        - containerPort: 8080
        env:
        - name: SPRING_PROFILES_ACTIVE
          value: "prod"
        - name: DB_PASSWORD
          valueFrom:
            secretKeyRef:
              name: db-secret
              key: password
        livenessProbe:
          httpGet:
            path: /actuator/health/liveness
            port: 8080
          initialDelaySeconds: 30
          periodSeconds: 10
        readinessProbe:
          httpGet:
            path: /actuator/health/readiness
            port: 8080
          initialDelaySeconds: 20
          periodSeconds: 5
        resources:
          requests:
            memory: "512Mi"
            cpu: "500m"
          limits:
            memory: "1Gi"
            cpu: "1000m"
```


