# T-Mobile Interview Prep - Part 3: Microservices & Kafka

## Microservices Architecture - Complete Answers

### 1. Microservices Communication Patterns

**Question:** How do microservices communicate with each other?

**Answer:**

#### **Synchronous Communication - REST with Feign Client**

```java
// 1. Add dependency
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

// 2. Enable Feign Clients
@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}

// 3. Define Feign Client Interface
@FeignClient(name = "user-service", url = "${user.service.url}")
public interface UserServiceClient {
    
    @GetMapping("/api/users/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);
    
    @PostMapping("/api/users")
    UserDTO createUser(@RequestBody UserDTO user);
    
    @GetMapping("/api/users/email/{email}")
    UserDTO getUserByEmail(@PathVariable("email") String email);
}

// 4. Use in Service
@Service
@Slf4j
public class OrderService {
    
    private final UserServiceClient userServiceClient;
    private final OrderRepository orderRepository;
    
    public OrderService(UserServiceClient userServiceClient,
                       OrderRepository orderRepository) {
        this.userServiceClient = userServiceClient;
        this.orderRepository = orderRepository;
    }
    
    public Order createOrder(OrderDTO orderDTO) {
        // Fetch user details from User Service
        UserDTO user = userServiceClient.getUserById(orderDTO.getUserId());
        
        if (user == null) {
            throw new BadRequestException("User not found");
        }
        
        Order order = new Order();
        order.setUserId(user.getId());
        order.setUserEmail(user.getEmail());
        order.setAmount(orderDTO.getAmount());
        order.setStatus("PENDING");
        
        return orderRepository.save(order);
    }
}

// 5. Error Handling with Feign
@Component
public class UserServiceFallback implements UserServiceClient {
    
    @Override
    public UserDTO getUserById(Long id) {
        log.error("Fallback: Unable to fetch user {}", id);
        return new UserDTO(id, "Unknown User", "unknown@example.com");
    }
    
    @Override
    public UserDTO createUser(UserDTO user) {
        throw new ServiceUnavailableException("User service is down");
    }
    
    @Override
    public UserDTO getUserByEmail(String email) {
        return new UserDTO(null, "Unknown", email);
    }
}
```

#### **Asynchronous Communication - Kafka**

```java
// 1. Kafka Configuration
@Configuration
public class KafkaProducerConfig {
    
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    
    @Bean
    public ProducerFactory<String, OrderEvent> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.ACKS_CONFIG, "all");
        config.put(ProducerConfig.RETRIES_CONFIG, 3);
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 5);
        return new DefaultKafkaProducerFactory<>(config);
    }
    
    @Bean
    public KafkaTemplate<String, OrderEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}

// 2. Event Classes
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String eventId;
    private String eventType;  // ORDER_CREATED, ORDER_UPDATED, ORDER_CANCELLED
    private Long orderId;
    private Long userId;
    private BigDecimal amount;
    private String status;
    private LocalDateTime timestamp;
}

// 3. Event Producer
@Service
@Slf4j
public class OrderEventProducer {
    
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    
    private static final String ORDER_TOPIC = "order-events";
    
    public OrderEventProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void publishOrderCreated(Order order) {
        OrderEvent event = new OrderEvent(
            UUID.randomUUID().toString(),
            "ORDER_CREATED",
            order.getId(),
            order.getUserId(),
            order.getAmount(),
            order.getStatus(),
            LocalDateTime.now()
        );
        
        kafkaTemplate.send(ORDER_TOPIC, order.getId().toString(), event)
            .addCallback(
                result -> log.info("Order event published: {}", event.getEventId()),
                ex -> log.error("Failed to publish order event", ex)
            );
    }
    
    public void publishOrderUpdated(Order order) {
        OrderEvent event = new OrderEvent(
            UUID.randomUUID().toString(),
            "ORDER_UPDATED",
            order.getId(),
            order.getUserId(),
            order.getAmount(),
            order.getStatus(),
            LocalDateTime.now()
        );
        
        kafkaTemplate.send(ORDER_TOPIC, order.getId().toString(), event);
    }
}

// 4. Event Consumer
@Service
@Slf4j
public class OrderEventConsumer {
    
    private final InventoryService inventoryService;
    private final NotificationService notificationService;
    
    public OrderEventConsumer(InventoryService inventoryService,
                             NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.notificationService = notificationService;
    }
    
    @KafkaListener(
        topics = "order-events",
        groupId = "inventory-service",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void handleOrderEvent(OrderEvent event) {
        log.info("Received order event: {}", event.getEventId());
        
        try {
            switch (event.getEventType()) {
                case "ORDER_CREATED":
                    inventoryService.reserveItems(event.getOrderId());
                    break;
                case "ORDER_CANCELLED":
                    inventoryService.releaseItems(event.getOrderId());
                    break;
                default:
                    log.warn("Unknown event type: {}", event.getEventType());
            }
        } catch (Exception e) {
            log.error("Error processing order event: {}", event.getEventId(), e);
            // Send to DLQ or retry
        }
    }
}

// 5. Consumer Configuration
@Configuration
public class KafkaConsumerConfig {
    
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    
    @Bean
    public ConsumerFactory<String, OrderEvent> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "inventory-service");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(config);
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderEvent> 
        kafkaListenerContainerFactory() {
        
        ConcurrentKafkaListenerContainerFactory<String, OrderEvent> factory =
            new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);  // 3 consumer threads
        factory.getContainerProperties().setAckMode(AckMode.MANUAL);
        return factory;
    }
}
```

---

### 2. Resilience Patterns - Circuit Breaker, Retry, Rate Limiter

**Question:** How do you handle failures in microservices?

**Answer:**

```xml
<!-- Add Resilience4j dependency -->
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-spring-boot2</artifactId>
    <version>1.7.1</version>
</dependency>
```

```yaml
# application.yml
resilience4j:
  circuitbreaker:
    instances:
      userService:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 10s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
  
  retry:
    instances:
      userService:
        maxAttempts: 3
        waitDuration: 1s
        enableExponentialBackoff: true
        exponentialBackoffMultiplier: 2
        retryExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.io.IOException
  
  ratelimiter:
    instances:
      userService:
        limitForPeriod: 10
        limitRefreshPeriod: 1s
        timeoutDuration: 0s
```

**Implementation:**

```java
@Service
@Slf4j
public class OrderService {
    
    private final UserServiceClient userServiceClient;
    
    // Circuit Breaker
    @CircuitBreaker(name = "userService", fallbackMethod = "getUserFallback")
    public UserDTO getUser(Long userId) {
        log.info("Calling user service for user: {}", userId);
        return userServiceClient.getUserById(userId);
    }
    
    // Fallback method
    private UserDTO getUserFallback(Long userId, Exception ex) {
        log.error("Circuit breaker activated for user: {}", userId, ex);
        return new UserDTO(userId, "Default User", "default@example.com");
    }
    
    // Retry
    @Retry(name = "userService", fallbackMethod = "getUserFallback")
    public UserDTO getUserWithRetry(Long userId) {
        log.info("Attempting to fetch user: {}", userId);
        return userServiceClient.getUserById(userId);
    }
    
    // Rate Limiter
    @RateLimiter(name = "userService")
    public UserDTO getUserRateLimited(Long userId) {
        return userServiceClient.getUserById(userId);
    }
    
    // Combine multiple patterns
    @CircuitBreaker(name = "userService", fallbackMethod = "getUserFallback")
    @Retry(name = "userService")
    @RateLimiter(name = "userService")
    public UserDTO getUserWithAllPatterns(Long userId) {
        return userServiceClient.getUserById(userId);
    }
}

// Circuit Breaker Event Listener
@Component
@Slf4j
public class CircuitBreakerEventListener {
    
    @Autowired
    public CircuitBreakerEventListener(CircuitBreakerRegistry registry) {
        registry.circuitBreaker("userService").getEventPublisher()
            .onStateTransition(event -> 
                log.info("Circuit Breaker State: {} -> {}", 
                    event.getStateTransition().getFromState(),
                    event.getStateTransition().getToState()))
            .onError(event -> 
                log.error("Circuit Breaker Error: {}", event.getThrowable().getMessage()))
            .onSuccess(event -> 
                log.debug("Circuit Breaker Success"));
    }
}
```

---

### 3. Saga Pattern for Distributed Transactions

**Question:** How do you handle distributed transactions in microservices?

**Answer:**

**Choreography-based Saga (Event-driven):**

```java
// 1. Order Service - Initiates the saga
@Service
@Slf4j
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    
    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        // Create order in PENDING state
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setAmount(orderDTO.getAmount());
        order.setStatus("PENDING");
        order = orderRepository.save(order);
        
        // Publish OrderCreated event
        OrderEvent event = new OrderEvent(
            UUID.randomUUID().toString(),
            "ORDER_CREATED",
            order.getId(),
            order.getUserId(),
            order.getAmount(),
            "PENDING",
            LocalDateTime.now()
        );
        
        kafkaTemplate.send("order-events", event);
        log.info("Order created and event published: {}", order.getId());
        
        return order;
    }
    
    // Listen for inventory reserved event
    @KafkaListener(topics = "inventory-events", groupId = "order-service")
    public void handleInventoryEvent(InventoryEvent event) {
        if ("INVENTORY_RESERVED".equals(event.getEventType())) {
            // Trigger payment
            PaymentEvent paymentEvent = new PaymentEvent(
                UUID.randomUUID().toString(),
                "PAYMENT_REQUESTED",
                event.getOrderId(),
                event.getAmount()
            );
            kafkaTemplate.send("payment-events", paymentEvent);
        } else if ("INVENTORY_RESERVATION_FAILED".equals(event.getEventType())) {
            // Cancel order
            cancelOrder(event.getOrderId());
        }
    }
    
    // Listen for payment events
    @KafkaListener(topics = "payment-events", groupId = "order-service")
    public void handlePaymentEvent(PaymentEvent event) {
        if ("PAYMENT_COMPLETED".equals(event.getEventType())) {
            completeOrder(event.getOrderId());
        } else if ("PAYMENT_FAILED".equals(event.getEventType())) {
            // Compensate - release inventory
            InventoryEvent compensateEvent = new InventoryEvent(
                UUID.randomUUID().toString(),
                "RELEASE_INVENTORY",
                event.getOrderId()
            );
            kafkaTemplate.send("inventory-events", compensateEvent);
            cancelOrder(event.getOrderId());
        }
    }
    
    @Transactional
    private void completeOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.setStatus("COMPLETED");
        orderRepository.save(order);
        log.info("Order completed: {}", orderId);
    }
    
    @Transactional
    private void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.setStatus("CANCELLED");
        orderRepository.save(order);
        log.info("Order cancelled: {}", orderId);
    }
}

// 2. Inventory Service
@Service
@Slf4j
public class InventoryService {
    
    private final InventoryRepository inventoryRepository;
    private final KafkaTemplate<String, InventoryEvent> kafkaTemplate;
    
    @KafkaListener(topics = "order-events", groupId = "inventory-service")
    @Transactional
    public void handleOrderEvent(OrderEvent event) {
        if ("ORDER_CREATED".equals(event.getEventType())) {
            try {
                // Reserve inventory
                boolean reserved = reserveInventory(event.getOrderId(), event.getAmount());
                
                if (reserved) {
                    InventoryEvent inventoryEvent = new InventoryEvent(
                        UUID.randomUUID().toString(),
                        "INVENTORY_RESERVED",
                        event.getOrderId(),
                        event.getAmount()
                    );
                    kafkaTemplate.send("inventory-events", inventoryEvent);
                    log.info("Inventory reserved for order: {}", event.getOrderId());
                } else {
                    InventoryEvent inventoryEvent = new InventoryEvent(
                        UUID.randomUUID().toString(),
                        "INVENTORY_RESERVATION_FAILED",
                        event.getOrderId(),
                        event.getAmount()
                    );
                    kafkaTemplate.send("inventory-events", inventoryEvent);
                    log.warn("Insufficient inventory for order: {}", event.getOrderId());
                }
            } catch (Exception e) {
                log.error("Error reserving inventory", e);
                // Publish failure event
            }
        } else if ("RELEASE_INVENTORY".equals(event.getEventType())) {
            releaseInventory(event.getOrderId());
        }
    }
    
    private boolean reserveInventory(Long orderId, BigDecimal amount) {
        // Business logic to reserve inventory
        return true;
    }
    
    private void releaseInventory(Long orderId) {
        // Business logic to release inventory
        log.info("Inventory released for order: {}", orderId);
    }
}

// 3. Payment Service
@Service
@Slf4j
public class PaymentService {
    
    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;
    
    @KafkaListener(topics = "payment-events", groupId = "payment-service")
    @Transactional
    public void handlePaymentRequest(PaymentEvent event) {
        if ("PAYMENT_REQUESTED".equals(event.getEventType())) {
            try {
                // Process payment
                boolean success = processPayment(event.getOrderId(), event.getAmount());
                
                if (success) {
                    PaymentEvent paymentEvent = new PaymentEvent(
                        UUID.randomUUID().toString(),
                        "PAYMENT_COMPLETED",
                        event.getOrderId(),
                        event.getAmount()
                    );
                    kafkaTemplate.send("payment-events", paymentEvent);
                    log.info("Payment completed for order: {}", event.getOrderId());
                } else {
                    PaymentEvent paymentEvent = new PaymentEvent(
                        UUID.randomUUID().toString(),
                        "PAYMENT_FAILED",
                        event.getOrderId(),
                        event.getAmount()
                    );
                    kafkaTemplate.send("payment-events", paymentEvent);
                    log.warn("Payment failed for order: {}", event.getOrderId());
                }
            } catch (Exception e) {
                log.error("Error processing payment", e);
            }
        }
    }
    
    private boolean processPayment(Long orderId, BigDecimal amount) {
        // Payment processing logic
        return true;
    }
}
```

---


