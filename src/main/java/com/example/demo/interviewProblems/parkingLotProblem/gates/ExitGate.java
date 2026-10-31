package com.example.demo.interviewProblems.parkingLotProblem.gates;
import com.example.demo.interviewProblems.parkingLotProblem.payment.*;
import com.example.demo.interviewProblems.parkingLotProblem.pricingStrategy.CostComputation;
import com.example.demo.interviewProblems.parkingLotProblem.Ticket;
import com.example.demo.interviewProblems.parkingLotProblem.parking.ParkingBuilding;

public class ExitGate {
    private final CostComputation computation;

    public ExitGate(CostComputation computation)
    {
        this.computation = computation;
    }

    public void exit(ParkingBuilding parkingBuilding, Ticket ticket, PaymentStrategy payment)
    {
        double amount = calculatePrice(ticket);
        boolean paymentStatus = payment.pay(amount);
        if(!paymentStatus)
        {
            throw new RuntimeException("Payment failed. Exit denied.");
        }

        parkingBuilding.release(ticket);
        System.out.println("Exit successful");
    }

    private double calculatePrice(Ticket ticket)
    {
        return computation.computeCost(ticket);
        
    }
}
