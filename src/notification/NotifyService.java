package notification;

import annotations.Autowired;
import annotations.Component;
import annotations.Qualifier;
import service.EmailService;
import service.MessageService;

@Component
public class NotifyService {
    @Autowired
    @Qualifier("emailService")
    private MessageService messageService;

//    public NotifyService(MessageService messageService) {
//        this.messageService = messageService;
//    }

    public void processMessage(String message) {
        messageService.sendMessage(message);
    }
}
