import context.ApplicationContext;
import notification.NotifyService;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        ApplicationContext context = new ApplicationContext();

        context.Reflection(Class.forName("service.MessageService"));
        context.Reflection(Class.forName("service.EmailService"));
        context.Reflection(Class.forName("service.SMSService"));

        NotifyService notifyService = (NotifyService) context.getBean("NotifyService");
        notifyService.processMessage("Hello World");
    }
}