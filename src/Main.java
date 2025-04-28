import context.ApplicationContext;
import notification.NotificationService;
import service.EmailService;
import service.SMSService;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        ApplicationContext context = new ApplicationContext();

        context.Reflection(Class.forName("service.MessageService"));
        context.Reflection(Class.forName("service.EmailService"));
        context.Reflection(Class.forName("service.SMSService"));

        NotificationService notificationService = (NotificationService) context.getBean("notify");
        notificationService.processMessage("Hello World");
    }
}