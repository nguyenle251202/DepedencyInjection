package service;

import annotations.Component;

@Component("emailService")
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email is sent:" + message);
    }
}
