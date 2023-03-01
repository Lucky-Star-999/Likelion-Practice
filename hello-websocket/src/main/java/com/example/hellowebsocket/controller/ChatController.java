package com.example.hellowebsocket.controller;

import com.example.hellowebsocket.model.ChatMessage;
import com.example.hellowebsocket.model.SaveChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private SaveChat saveChat;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        saveChat.getSenders().add(chatMessage);
        System.out.println(saveChat.getSenders());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        saveChat.getReceivers().add(chatMessage);
        System.out.println(saveChat.getReceivers());
        return chatMessage;
    }
}
