package com.example.demo.designPattern.strategyDesignPattern.paymentStrategy.paymentStrategyTypes;
import com.example.demo.designPattern.strategyDesignPattern.paymentStrategy.PaymentStrategy;

public class CardPayment implements PaymentStrategy{
    
    @Override 
    public boolean pay()
    {
        System.out.println("Pay by Card----");
        return true;
    }

}