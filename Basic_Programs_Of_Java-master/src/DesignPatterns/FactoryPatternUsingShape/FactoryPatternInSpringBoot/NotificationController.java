package DesignPatterns.FactoryPatternUsingShape.FactoryPatternInSpringBoot;

//@RestController
//@RequestMapping("/notify")
public class NotificationController {

    //@Autowired
    private NotificationFactory factory;

    //@GetMapping("/{type}")
    public String sendNotification(/*@PathVariable*/ String type) {
        NotificationService service = factory.getNotificationService(type);
        service.sendNotification("Your order has been placed successfully!");
        return "Notification sent via " + type;
    }
}
//OUTPUT:
//GET /notify/EMAIL → Sending EMAIL: Your order has been placed successfully!
