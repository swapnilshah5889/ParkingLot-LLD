package com.swapnilshah5889.parkinglot;

import com.swapnilshah5889.parkinglot.controllers.TicketController;
import com.swapnilshah5889.parkinglot.dto.GenerateTicketRequest;
import com.swapnilshah5889.parkinglot.dto.GenerateTicketResponse;
import com.swapnilshah5889.parkinglot.models.Ticket;
import com.swapnilshah5889.parkinglot.models.constants.VehicleType;
import com.swapnilshah5889.parkinglot.repositories.ParkingLotRepository;
import com.swapnilshah5889.parkinglot.repositories.ParkingSpotRepository;
import com.swapnilshah5889.parkinglot.repositories.TicketRepository;
import com.swapnilshah5889.parkinglot.service.GateService;
import com.swapnilshah5889.parkinglot.service.TicketService;
import com.swapnilshah5889.parkinglot.service.VehicleService;
import com.swapnilshah5889.parkinglot.strategy.SpotAssignmentStrategy.RandomSpotAssignmentStrategy;
import com.swapnilshah5889.parkinglot.strategy.SpotAssignmentStrategy.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {

        // Build central repository to manage all objects
        ObjectRegistry objectRegistry = new ObjectRegistry();
        VehicleService vehicleService = new VehicleService();
        GateService gateService = new GateService();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(
                parkingLotRepository,
                parkingSpotRepository);
        TicketService ticketService = new TicketService(
                vehicleService,
                gateService,
                spotAssignmentStrategy,
                ticketRepository);
        TicketController ticketController = new TicketController(
                ticketService
        );
        objectRegistry.register("vehicleService", vehicleService);
        objectRegistry.register("gateService", gateService);
        objectRegistry.register("ticketRepository", ticketRepository);
        objectRegistry.register("parkingLotRepository", parkingLotRepository);
        objectRegistry.register("parkingSpotRepository", parkingSpotRepository);
        objectRegistry.register("spotAssignmentStrategy", spotAssignmentStrategy);
        objectRegistry.register("ticketService", ticketService);
        objectRegistry.register("ticketController", ticketController);

        // Build request
        GenerateTicketRequest request = new GenerateTicketRequest();
        request.setVehicleNumber("GJ01KJ5889");
        request.setVehicleType(VehicleType.MEDIUM);
        request.setGateId(123L);

        // Get ticket
        GenerateTicketResponse response = ticketController.generateTicket(request);
        Ticket ticket = response.getTicket();

        // TODO -> Handle payment, generate bill and so on...
    }
}