import context.ApplicationContext;
import notification.NotifyService;
import service.EmailService;
import service.MessageService;
import service.SMSService;

import java.lang.reflect.InvocationTargetException;

import static context.ApplicationContext.beans;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ApplicationContext context = new ApplicationContext();
        context.Reflection(MessageService.class);
        context.Reflection(EmailService.class);
        context.Reflection(SMSService.class);
        context.Reflection(NotifyService.class);

        NotifyService mess = (NotifyService) context.getBean("notify");
        System.out.println("Bean: " +beans);
        mess.processMessage("Hello World");
    }
}