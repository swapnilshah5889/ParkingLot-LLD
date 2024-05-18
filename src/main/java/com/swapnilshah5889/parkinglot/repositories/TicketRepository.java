package com.swapnilshah5889.parkinglot.repositories;

import com.swapnilshah5889.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Long, Ticket> ticketMap;
    private Long ticketSequence;
    public TicketRepository() {
        ticketMap = new HashMap<>();
        ticketSequence = 0l;
    }

    public Ticket saveTicket(Ticket ticket) {
        ticketSequence+=1;
        ticket.setId(ticketSequence);
        ticketMap.put(ticketSequence, ticket);
        return ticket;
    }
}
