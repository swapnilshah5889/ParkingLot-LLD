package com.swapnilshah5889.parkinglot.models;

import com.swapnilshah5889.parkinglot.models.constants.BillStatus;

import java.util.Date;
import java.util.List;

public class Bill {
    private Long id;
    private Ticket ticket;
    private Date exitTime;
    private int amount;
    private Operator operator;
    private Gate gate;
    private List<Payment> payments;
    private BillStatus billStatus;
}
