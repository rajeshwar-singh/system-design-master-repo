package com.example.demo.designPattern.strategyDesignPattern.paymentType;
import com.example.demo.designPattern.strategyDesignPattern.Payment;

import com.example.demo.designPattern.strategyDesignPattern.paymentStrategy.PaymentStrategy;
public class OfflinePayment extends Payment{
    
    public OfflinePayment(PaymentStrategy paymentStrategy)
    {
        super(paymentStrategy);
    }
}
