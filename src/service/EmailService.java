package service;

import annotations.Component;
import annotations.Qualifier;

@Component("emailservice")
@Qualifier("emailService")
public class EmailService implements MessageService {

    @Override

    public void sendMessage(String message) {
        System.out.println("Email is sent:" + message);
    }
}
