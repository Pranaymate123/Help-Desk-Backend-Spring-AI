package com.hekpdesk.tools;

import com.hekpdesk.entity.Ticket;
import com.hekpdesk.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;


    @Tool(description = "This tool helps to create new ticket in database")
    public Ticket createTicketTool(@ToolParam(description = "Ticket fields required to create the new ticket") Ticket ticket)
    {
        try{
            System.out.println("Going to create the ticket");
            System.out.println(ticket);
            return ticketService.createTicket(ticket);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Tool(description = "This tool helps to retrieve all the tickets raised by the user with the given email")
    public List<Ticket> getTicketEmail(@ToolParam(description = "email id  of the user whose tickets are required ") String email)
    {
        return ticketService.getTicketsByUsername(email);
    }

    @Tool(description = "This tool helps to update the ticket")
    public Ticket updateTicket(@ToolParam(description = "Id of the ticket") Long ticketId ,@ToolParam(description = "New ticket details" ) Ticket ticket )
    {
        return ticketService.updateTicket(ticketId,ticket);
    }
}
