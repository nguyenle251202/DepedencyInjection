package notification;

import annotations.Autowired;
import annotations.Component;
import annotations.Qualifier;
import service.MessageService;

@Component("notify")
public class NotifyService {
    @Autowired
    @Qualifier("SMSService")
    private MessageService messageService;

    public void processMessage(String message) {
        messageService.sendMessage(message);
    }
}
