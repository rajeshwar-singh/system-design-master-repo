package com.example.demo.designPattern.strategyDesignPattern;

import com.example.demo.designPattern.strategyDesignPattern.paymentStrategy.PaymentStrategy;

public abstract class Payment {
    PaymentStrategy paymentStrategy;
    public Payment(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy = paymentStrategy;
    }

    //delegator method
    public boolean completePayment()
    {
        System.out.println("Payment started :  ");
        System.out.println("Payment completed : ");
        return paymentStrategy.pay();
    }
}
