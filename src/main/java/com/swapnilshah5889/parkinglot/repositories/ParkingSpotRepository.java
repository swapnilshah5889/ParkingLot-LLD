package com.swapnilshah5889.parkinglot.repositories;

import com.swapnilshah5889.parkinglot.models.ParkingFloor;
import com.swapnilshah5889.parkinglot.models.ParkingLot;
import com.swapnilshah5889.parkinglot.models.ParkingSpot;
import com.swapnilshah5889.parkinglot.models.constants.ParkingSpotStatus;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {

    public List<ParkingSpot> getParkingSpots(ParkingLot parkingLot) {
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        List<ParkingSpot> spots = new ArrayList<>();
        for(ParkingFloor floor : parkingFloors) {
            for(ParkingSpot spot : floor.getParkingSpots()) {
                if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)) {
                    spots.add(spot);
                }
            }
        }

        return spots;
    }

}
