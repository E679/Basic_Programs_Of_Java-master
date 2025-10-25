package DesignPatterns.FactoryPatternUsingShape.FactoryPatternInSpringBoot;

//import org.springframework.stereotype.Service;

//@Service("emailNotification")
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
