package com.example.hellowebsocket.model;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaveChat {
    private List<ChatMessage> senders = new ArrayList<>();
    private List<ChatMessage> receivers = new ArrayList<>();
}
