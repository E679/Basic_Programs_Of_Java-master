package DesignPatterns.FactoryPatternUsingShape.FactoryPatternInSpringBoot;

//@Component
public class NotificationFactory {

    //@Autowired
    private ApplicationContext context;

    public NotificationService getNotificationService(String type) {
        if ("EMAIL".equalsIgnoreCase(type))
            return (NotificationService) context.getBean("emailNotification");
        else if ("SMS".equalsIgnoreCase(type))
            return (NotificationService) context.getBean("smsNotification");
        else
            throw new IllegalArgumentException("Unknown type: " + type);
    }
}
