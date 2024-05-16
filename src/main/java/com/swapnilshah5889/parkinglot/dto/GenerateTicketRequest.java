package com.swapnilshah5889.parkinglot.dto;

import com.swapnilshah5889.parkinglot.models.Ticket;
import com.swapnilshah5889.parkinglot.models.constants.VehicleType;

public class GenerateTicketRequest {
    private String vehicleNumber;
    private Long gateId;
    private VehicleType vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
