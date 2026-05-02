package com.hekpdesk.controller;

import com.hekpdesk.entity.Ticket;
import com.hekpdesk.service.TicketService;
import com.hekpdesk.service.impl.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/helpdesk")
public class AiController {

    //Constructor injection
    private final AiService aiService;

    @PostMapping("/chat")
    public ResponseEntity<String> getResponse(@RequestBody String q ,@RequestHeader("email") String emailId)
    {
        System.out.println("API Called ");
        String response = aiService.getResponseFromAssistant(q , emailId);

        return  ResponseEntity.status(200).body(response);
    }
    @PostMapping("/stream")
    public Flux<String> getStreamResponse(@RequestBody String q , @RequestHeader("email") String emailId)
    {
        System.out.println("Stream Chat API Called ");
        String response = aiService.getResponseFromAssistant(q , emailId);
        return  aiService.streamResponseFromAssistant(q,emailId);
    }


}
