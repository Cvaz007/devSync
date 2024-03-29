package riwi.devSync.web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import riwi.devSync.domain.brookcast.Message;

@Controller
//! I hope to create a microservice, because I have problems with the dependencies right now.
public class MessageController {
    @MessageMapping("/sent")
    @SendTo("/topic/message")
    public Message send(Message message) {
        return new Message(message.name(),message.content());
    }
}
