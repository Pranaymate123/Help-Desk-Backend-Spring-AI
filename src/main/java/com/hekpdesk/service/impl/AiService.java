package com.hekpdesk.service.impl;

import com.hekpdesk.tools.CurrentDateTimeTool;
import com.hekpdesk.tools.EmailTool;
import com.hekpdesk.tools.TicketDatabaseTool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Data
public class AiService {
    //Constructor Injection
    private final ChatClient chatClient;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPromptResource;
    private final TicketDatabaseTool ticketDatabaseTool;

    private final CurrentDateTimeTool currentDateTimeTool;

    private final EmailTool emailTool;

    private final ChatMemory chatMemory;

    public String getResponseFromAssistant(String query ,String emailId)
    {
         //Basic Call
        return chatClient.prompt()
//                .advisors(MessageChatMemoryAdvisor.builder(chatMemory).conversationId(emailId).build())
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,emailId))
                .system(systemPromptResource)
                .tools(ticketDatabaseTool,emailTool,currentDateTimeTool)
                .user(query)
                .call()
                .content();
    }

    public Flux<String> streamResponseFromAssistant(String query, String emailId)
    {
        return chatClient.prompt()
//                .advisors(MessageChatMemoryAdvisor.builder(chatMemory).conversationId(emailId).build())
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,emailId))
                .system(systemPromptResource)
                .tools(ticketDatabaseTool,emailTool,currentDateTimeTool)
                .user(query)
            .stream()
                .content();
    }

}
