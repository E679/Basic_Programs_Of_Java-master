# T-Mobile Interview Prep - Part 2: Spring Boot & Microservices

## Spring Boot Deep Dive - Complete Answers

### 1. Spring Boot Annotations - Detailed Explanation

**Question:** Explain key Spring Boot annotations.

**Answer:**

```java
// @SpringBootApplication
// Combines @Configuration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired  // Field injection (not recommended)
    private UserService userService;
    
    // Constructor injection (RECOMMENDED)
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(
        @Valid @RequestBody UserDTO dto) {
        User user = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}

// @Service - Business logic layer
@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    
    @Transactional
    public User create(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }
}

// @Repository - Data access layer
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.status = :status")
    List<User> findByStatus(@Param("status") String status);
    
    @Query(value = "SELECT * FROM users WHERE created_at > :date", 
           nativeQuery = true)
    List<User> findRecentUsers(@Param("date") LocalDateTime date);
}

// @Configuration - Java-based configuration
@Configuration
public class AppConfig {
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}

// @Component - Generic stereotype
@Component
public class EmailValidator {
    
    public boolean isValid(String email) {
        return email != null && email.contains("@");
    }
}
```

---

### 2. Exception Handling - Complete Guide

**Question:** How do you handle exceptions in Spring Boot?

**Answer:**

```java
// 1. Custom Exception Classes
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

// 2. Error Response DTO
@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}

// 3. Global Exception Handler
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(
        ResourceNotFoundException ex,
        WebRequest request) {
        
        ErrorResponse error = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Not Found",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
        );
        
        log.error("Resource not found: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(
        BadRequestException ex,
        WebRequest request) {
        
        ErrorResponse error = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Bad Request",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
        );
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
        MethodArgumentNotValidException ex) {
        
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
        Exception ex,
        WebRequest request) {
        
        ErrorResponse error = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
        );
        
        log.error("Unexpected error: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

// 4. Validation with Bean Validation
@Data
public class UserDTO {
    
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than 100")
    private Integer age;
    
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phone;
}

// 5. Usage in Controller
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO dto) {
        // If validation fails, MethodArgumentNotValidException is thrown
        // and handled by GlobalExceptionHandler
        User user = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        // If not found, throws ResourceNotFoundException
        return ResponseEntity.ok(user);
    }
}
```

---

### 3. Spring Boot Profiles - Complete Guide

**Question:** How do you manage different environments in Spring Boot?

**Answer:**

```yaml
# application.yml (default)
spring:
  application:
    name: user-service
  profiles:
    active: ${SPRING_PROFILE:dev}

server:
  port: 8080

logging:
  level:
    root: INFO

---
# application-dev.yml
spring:
  config:
    activate:
      on-profile: dev
  
  datasource:
    url: jdbc:postgresql://localhost:5432/devdb
    username: devuser
    password: devpass
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  
  kafka:
    bootstrap-servers: localhost:9092

logging:
  level:
    root: DEBUG
    com.example: TRACE

---
# application-qa.yml
spring:
  config:
    activate:
      on-profile: qa
  
  datasource:
    url: jdbc:postgresql://qa-db.example.com:5432/qadb
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
  
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false
  
  kafka:
    bootstrap-servers: qa-kafka.example.com:9092

---
# application-prod.yml
spring:
  config:
    activate:
      on-profile: prod
  
  datasource:
    url: jdbc:postgresql://prod-db.example.com:5432/proddb
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
  
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false
  
  kafka:
    bootstrap-servers: prod-kafka.example.com:9092
    producer:
      acks: all
      retries: 3

logging:
  level:
    root: WARN
    com.example: INFO
```

**Java Configuration with Profiles:**

```java
@Configuration
@Profile("dev")
public class DevConfig {
    
    @Bean
    public DataSource dataSource() {
        // Dev-specific datasource configuration
        return new HikariDataSource();
    }
}

@Configuration
@Profile("prod")
public class ProdConfig {
    
    @Bean
    public DataSource dataSource() {
        // Prod-specific datasource configuration with connection pooling
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        return new HikariDataSource(config);
    }
}

// Conditional Bean based on property
@Configuration
public class CacheConfig {
    
    @Bean
    @ConditionalOnProperty(name = "cache.enabled", havingValue = "true")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("users", "products");
    }
}
```

**Running with Different Profiles:**

```bash
# Command line
java -jar app.jar --spring.profiles.active=prod

# Environment variable
export SPRING_PROFILES_ACTIVE=prod
java -jar app.jar

# In IDE (IntelliJ)
VM Options: -Dspring.profiles.active=dev

# Docker
docker run -e SPRING_PROFILES_ACTIVE=prod myapp:latest

# Kubernetes ConfigMap
apiVersion: v1
kind: ConfigMap
metadata:
  name: app-config
data:
  SPRING_PROFILES_ACTIVE: "prod"
```

---

### 4. Spring Boot Actuator - Monitoring & Health Checks

**Question:** How do you monitor Spring Boot applications?

**Answer:**

```xml
<!-- pom.xml -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

```yaml
# application.yml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus,env,loggers
      base-path: /actuator
  
  endpoint:
    health:
      show-details: always
      probes:
        enabled: true
  
  metrics:
    export:
      prometheus:
        enabled: true
    tags:
      application: ${spring.application.name}
      environment: ${spring.profiles.active}

info:
  app:
    name: User Service
    version: 1.0.0
    description: User management microservice
```

**Custom Health Indicator:**

```java
@Component
public class DatabaseHealthIndicator implements HealthIndicator {
    
    @Autowired
    private DataSource dataSource;
    
    @Override
    public Health health() {
        try (Connection conn = dataSource.getConnection()) {
            if (conn.isValid(1)) {
                return Health.up()
                    .withDetail("database", "PostgreSQL")
                    .withDetail("status", "Connected")
                    .build();
            }
        } catch (Exception e) {
            return Health.down()
                .withDetail("error", e.getMessage())
                .build();
        }
        
        return Health.down().build();
    }
}

@Component
public class KafkaHealthIndicator implements HealthIndicator {
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Override
    public Health health() {
        try {
            // Try to get metadata
            kafkaTemplate.getDefaultTopic();
            return Health.up()
                .withDetail("kafka", "Connected")
                .build();
        } catch (Exception e) {
            return Health.down()
                .withDetail("error", e.getMessage())
                .build();
        }
    }
}
```

**Kubernetes Probes:**

```yaml
# deployment.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: user-service
spec:
  template:
    spec:
      containers:
      - name: user-service
        image: user-service:1.0.0
        ports:
        - containerPort: 8080
        
        livenessProbe:
          httpGet:
            path: /actuator/health/liveness
            port: 8080
          initialDelaySeconds: 30
          periodSeconds: 10
          timeoutSeconds: 5
          failureThreshold: 3
        
        readinessProbe:
          httpGet:
            path: /actuator/health/readiness
            port: 8080
          initialDelaySeconds: 20
          periodSeconds: 5
          timeoutSeconds: 3
          failureThreshold: 3
```

**Custom Metrics:**

```java
@Service
public class UserService {
    
    private final MeterRegistry meterRegistry;
    private final Counter userCreatedCounter;
    private final Timer userFetchTimer;
    
    public UserService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        
        this.userCreatedCounter = Counter.builder("users.created")
            .description("Total users created")
            .tag("service", "user-service")
            .register(meterRegistry);
        
        this.userFetchTimer = Timer.builder("users.fetch.time")
            .description("Time to fetch user")
            .register(meterRegistry);
    }
    
    public User createUser(UserDTO dto) {
        User user = new User();
        // ... create user
        userCreatedCounter.increment();
        return user;
    }
    
    public User findById(Long id) {
        return userFetchTimer.record(() -> {
            return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        });
    }
}
```

---


