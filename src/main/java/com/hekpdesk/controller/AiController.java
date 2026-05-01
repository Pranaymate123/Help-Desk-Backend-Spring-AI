package com.hekpdesk.controller;

import com.hekpdesk.entity.Ticket;
import com.hekpdesk.service.TicketService;
import com.hekpdesk.service.impl.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ai")
public class AiController {

    //Constructor injection
    private final AiService aiService;

    @PostMapping("/chat")
    public ResponseEntity<String> getResponse(@RequestBody String q)
    {
        System.out.println("API Called ");
        String response = aiService.getResponseFromAssistant(q);

        return  ResponseEntity.status(200).body(response);
    }

}
