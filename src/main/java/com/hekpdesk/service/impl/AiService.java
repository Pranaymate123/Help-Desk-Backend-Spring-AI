package com.hekpdesk.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class AiService {
    //Constructor Injection
    private final ChatClient chatClient;


    public String getResponseFromAssistant(String query)
    {
         //Basic Call
        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }

}
