package com.hekpdesk.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder)
    {
        return builder
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultSystem("Summarize the Response Within Or less than 400 words")
                .build();
    }
}
