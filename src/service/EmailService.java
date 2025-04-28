package service;

import annotations.Autowired;
import annotations.Component;
import annotations.Qualifier;

@Component
@Qualifier("emailService")
public class EmailService implements MessageService {

    @Autowired
    public void sendMessage(String message) {
        System.out.println("Email is sent:" + message);
    }
}
