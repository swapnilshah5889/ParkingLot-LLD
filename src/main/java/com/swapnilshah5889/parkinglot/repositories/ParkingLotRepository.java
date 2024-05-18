package com.swapnilshah5889.parkinglot.repositories;

import com.swapnilshah5889.parkinglot.models.Gate;
import com.swapnilshah5889.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLotMap;
    private Long parkingLotSequence;

    public ParkingLotRepository() {
        parkingLotSequence = 0l;
        parkingLotMap = new HashMap<>();
    }

    public ParkingLot getParkingLot(Gate gate) {
        for(ParkingLot parkingLot : parkingLotMap.values()) {
            if(parkingLot.getGates().contains(gate)) {
                return parkingLot;
            }
        }

        return null;
    }
}
