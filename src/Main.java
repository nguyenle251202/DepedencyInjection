import context.ApplicationContext;
import notification.NotifyService;
import service.EmailService;
import service.MessageService;
import service.SMSService;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        ApplicationContext context = new ApplicationContext();

        context.Reflection(MessageService.class);
        context.Reflection(EmailService.class);
        context.Reflection(SMSService.class);

        NotifyService notifyService = (NotifyService) context.getBean("email-service");
        notifyService.processMessage("Hello World");
    }
}