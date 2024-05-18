package com.swapnilshah5889.parkinglot.dto;

import com.swapnilshah5889.parkinglot.models.Ticket;
import com.swapnilshah5889.parkinglot.models.constants.ResponseStatus;

public class GenerateTicketResponse {
    private Ticket ticket;
    ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
