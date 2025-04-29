package notification;

import annotations.Autowired;
import annotations.Component;
import annotations.Qualifier;
import service.MessageService;

@Component
public class NotifyService {
    @Autowired
    @Qualifier("email-service")
    private MessageService messageService;

    public void processMessage(String message) {
        messageService.sendMessage(message);
    }
}
