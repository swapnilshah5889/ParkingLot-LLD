package com.swapnilshah5889.parkinglot.controllers;

import com.swapnilshah5889.parkinglot.dto.GenerateTicketRequest;
import com.swapnilshah5889.parkinglot.dto.GenerateTicketResponse;
import com.swapnilshah5889.parkinglot.exceptions.NoParkingSpotAvailableException;
import com.swapnilshah5889.parkinglot.models.Ticket;
import com.swapnilshah5889.parkinglot.models.Vehicle;
import com.swapnilshah5889.parkinglot.models.constants.ResponseStatus;
import com.swapnilshah5889.parkinglot.service.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponse generateTicket(GenerateTicketRequest generateTicketRequest) {
        GenerateTicketResponse response = new GenerateTicketResponse();
        try {
            Ticket ticket = ticketService.generateTicket(
                    generateTicketRequest.getVehicleNumber(),
                    generateTicketRequest.getVehicleType(),
                    generateTicketRequest.getGateId()
            );

            response.setTicket(ticket);
            response.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (NoParkingSpotAvailableException e) {
            response.setResponseStatus(null);
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }
}
