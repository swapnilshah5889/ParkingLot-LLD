package com.swapnilshah5889.parkinglot.models;

import com.swapnilshah5889.parkinglot.models.constants.ParkingLotStatus;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;
    private String name;
    private String address;
}
