package com.hekpdesk.service.impl;

import com.hekpdesk.entity.Ticket;
import com.hekpdesk.repository.TicketRepository;
import com.hekpdesk.service.TicketService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.query.SortDirection;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicket(Long ticketId) {
       return ticketRepository.findById(ticketId).orElseThrow(()->new RuntimeException("Ticket With Given Id Not Found"));
    }

    @Override
    public Ticket updateTicket(Long ticketId, Ticket ticket) {
       Ticket existingTicket=ticketRepository.findById(ticketId).orElseThrow(()->new RuntimeException("Ticket With Given Id Not Found"));

       if(ticket.getStatus()!=null)
       {
           existingTicket.setStatus(ticket.getStatus());
       }
       if(ticket.getPriority()!=null)
       {
           existingTicket.setPriority(ticket.getPriority());
       }
       if(ticket.getSummary()!=null)
       {
           existingTicket.setSummary(ticket.getSummary());
       }

        return ticketRepository.save(existingTicket);
    }

    @Override
    public List<Ticket> getAllTickets() {

        return ticketRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @Override
    public List<Ticket> getTicketsByUsername(String username) {
        return ticketRepository.findByUsername(username);
    }
}
