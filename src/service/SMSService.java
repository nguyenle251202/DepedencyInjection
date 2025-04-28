package service;

import annotations.Autowired;
import annotations.Component;

@Component("smsService")
public class SMSService implements MessageService {
    @Autowired
    public void sendMessage(String message) {
        System.out.println("SMS is sent: " + message);
    }
}
