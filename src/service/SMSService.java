package service;

import annotations.Component;
import annotations.Qualifier;

@Component("smsservice")
@Qualifier("smsService")
public class SMSService implements MessageService {

    @Override
    public void sendMessage(String message) {
        System.out.println("SMS is sent: " + message);
    }
}
