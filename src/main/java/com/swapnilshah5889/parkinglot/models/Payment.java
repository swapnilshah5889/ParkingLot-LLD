package com.swapnilshah5889.parkinglot.models;

import com.swapnilshah5889.parkinglot.models.constants.PaymentMode;
import com.swapnilshah5889.parkinglot.models.constants.PaymentStatus;

public class Payment {
    private Long id;
    private PaymentMode paymentMode;
    private int amount;
    private PaymentStatus paymentStatus;
    private String referenceId;
}
