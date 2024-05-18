package com.swapnilshah5889.parkinglot.strategy.SpotAssignmentStrategy;

import com.swapnilshah5889.parkinglot.models.Gate;
import com.swapnilshah5889.parkinglot.models.ParkingSpot;
import com.swapnilshah5889.parkinglot.models.constants.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
