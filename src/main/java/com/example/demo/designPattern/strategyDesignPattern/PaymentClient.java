package com.example.demo.designPattern.strategyDesignPattern;
import com.example.demo.designPattern.strategyDesignPattern.paymentType.*;
import com.example.demo.designPattern.strategyDesignPattern.paymentStrategy.paymentStrategyTypes.*;
public class PaymentClient {

    public void makePayment()
    {
        Payment payment = new OnlinePayment(new UPIPayment());
        payment.completePayment();
    }
    
}
