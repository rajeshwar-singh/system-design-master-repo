package com.example.demo.interviewProblems.parkingLotProblem.payment;

public class UPIPayment implements PaymentStrategy{

    @Override 
    public boolean pay(double amount)
    {
        System.out.println("UPI paid: " + amount);
        return true;
    }
    
}
