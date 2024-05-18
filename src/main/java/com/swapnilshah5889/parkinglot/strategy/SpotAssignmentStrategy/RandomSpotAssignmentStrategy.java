package com.swapnilshah5889.parkinglot.strategy.SpotAssignmentStrategy;

import com.swapnilshah5889.parkinglot.models.Gate;
import com.swapnilshah5889.parkinglot.models.ParkingLot;
import com.swapnilshah5889.parkinglot.models.ParkingSpot;
import com.swapnilshah5889.parkinglot.models.constants.VehicleType;
import com.swapnilshah5889.parkinglot.repositories.ParkingLotRepository;
import com.swapnilshah5889.parkinglot.repositories.ParkingSpotRepository;

import java.util.List;
import java.util.Random;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    ParkingLotRepository parkingLotRepository;
    ParkingSpotRepository parkingSpotRepository;
    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository,
                                        ParkingSpotRepository parkingSpotRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {

        // Get parking lot
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(gate);
        // Get available parking spots
        List<ParkingSpot> parkingSpots = parkingSpotRepository.getParkingSpots(parkingLot);
        // Return a random parking spot
        int randomIndex = new Random().nextInt(parkingSpots.size());
        return parkingSpots.get(randomIndex);

    }
}
