package com.example.demo.interviewProblems.parkingLotProblem.pricingStrategy;

import com.example.demo.interviewProblems.parkingLotProblem.Ticket;

public class CostComputation {

    private final ParkingPricingStrategy parkingPricingStrategy;
    public CostComputation(ParkingPricingStrategy parkingPricingStrategy)
    {
        this.parkingPricingStrategy = parkingPricingStrategy;
    }

    public double computeCost(Ticket ticket)
    {
        return parkingPricingStrategy.calculate(ticket);
    }
}
