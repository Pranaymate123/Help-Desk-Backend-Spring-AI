package com.hekpdesk.service;

import com.hekpdesk.entity.Ticket;

import java.util.List;

public interface TicketService {

    public Ticket createTicket(Ticket ticket);

    public  Ticket getTicket(Long ticketId);

    public Ticket updateTicket(Long ticketId, Ticket ticket);

    public List<Ticket> getAllTickets();
    public List<Ticket> getTicketsByUsername(String username);


}
