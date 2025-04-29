package notification;

import annotations.Autowired;
import annotations.Component;
import annotations.Qualifier;
import service.EmailService;
import service.MessageService;

@Component("sms-service")
@Qualifier("notifyService")
public class NotifyService {
    @Autowired

    private MessageService messageService;

//    public NotifyService(MessageService messageService) {
//        this.messageService = messageService;
//    }

    public void processMessage(String message) {
        messageService.sendMessage(message);
    }
}
