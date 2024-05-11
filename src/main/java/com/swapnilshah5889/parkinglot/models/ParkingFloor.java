package com.swapnilshah5889.parkinglot.models;

import com.swapnilshah5889.parkinglot.models.constants.ParkingSpotStatus;

import java.util.List;

public class ParkingFloor {
    private Long id;
    private int number;
    private List<ParkingSpot> parkingSpots;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;

}
