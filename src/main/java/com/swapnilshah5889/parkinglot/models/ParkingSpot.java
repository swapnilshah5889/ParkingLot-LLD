package com.swapnilshah5889.parkinglot.models;

import com.swapnilshah5889.parkinglot.models.constants.ParkingSpotStatus;
import com.swapnilshah5889.parkinglot.models.constants.VehicleType;

import java.util.List;

public class ParkingSpot {
    private Long id;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> supportedVehicleTypes;
    private int number;
}
