package com.swapnilshah5889.parkinglot.models;

import java.util.Date;

public class Ticket extends BaseModel {
    private Date entryTime;
    private Operator operator;
    private Gate gate;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
}
