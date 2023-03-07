package com.example.hellorediswebsocket.dto;

import com.example.hellorediswebsocket.enumf.MessageType;
import lombok.Data;

@Data
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;

    // constructors, getters and setters
}
