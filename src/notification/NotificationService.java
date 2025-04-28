package notification;

import annotations.Autowired;
import annotations.Qualifier;
import service.MessageService;

public class NotificationService {
    @Autowired
    @Qualifier("emailService")
    private MessageService messageService;
    public void notify(String message) {
        //
    }
}
