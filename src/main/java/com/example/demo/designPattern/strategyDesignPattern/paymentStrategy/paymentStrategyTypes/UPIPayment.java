package com.example.demo.designPattern.strategyDesignPattern.paymentStrategy.paymentStrategyTypes;
import com.example.demo.designPattern.strategyDesignPattern.paymentStrategy.*;

public class UPIPayment implements PaymentStrategy{

    @Override 
    public boolean pay()
    {
        System.out.println("Pay by UPI-----");
        return true;
    }
    
}
