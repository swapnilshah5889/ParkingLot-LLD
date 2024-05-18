package com.swapnilshah5889.parkinglot.service;

import com.swapnilshah5889.parkinglot.exceptions.NoParkingSpotAvailableException;
import com.swapnilshah5889.parkinglot.models.Gate;
import com.swapnilshah5889.parkinglot.models.ParkingSpot;
import com.swapnilshah5889.parkinglot.models.Ticket;
import com.swapnilshah5889.parkinglot.models.Vehicle;
import com.swapnilshah5889.parkinglot.models.constants.VehicleType;
import com.swapnilshah5889.parkinglot.repositories.TicketRepository;
import com.swapnilshah5889.parkinglot.strategy.SpotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    VehicleService vehicleService;
    GateService gateService;
    SpotAssignmentStrategy spotAssignmentStrategy;
    TicketRepository ticketRepository;

    TicketService(VehicleService vehicleService, GateService gateService,
                  SpotAssignmentStrategy spotAssignmentStrategy,
                  TicketRepository ticketRepository) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType,
                                 Long gateId) throws NoParkingSpotAvailableException {

        // Fetch vehicle object using vehicle number
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        // Vehicle does not exists, register a new vehicle
        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        // Get gate object
        Gate gate = gateService.getGate(gateId);

        // Build ticket object
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());

        // Assign parking spot
        ParkingSpot spot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        if(spot == null) {
            throw new NoParkingSpotAvailableException("No parking spot available");
        }
        ticket.setParkingSpot(spot);

        Ticket savedTicket = ticketRepository.saveTicket(ticket);
        return savedTicket;
    }
}
