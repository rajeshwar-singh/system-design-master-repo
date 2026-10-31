package com.example.demo.designPattern.strategyDesignPattern.paymentType;

import com.example.demo.designPattern.strategyDesignPattern.Payment;
import com.example.demo.designPattern.strategyDesignPattern.paymentStrategy.PaymentStrategy;

public class OnlinePayment extends Payment {

    
    public OnlinePayment(PaymentStrategy paymentStrategy) {
        super(paymentStrategy);
    }

}
