package com.example.demo.interviewProblems.parkingLotProblem.pricingStrategy;

import com.example.demo.interviewProblems.parkingLotProblem.Ticket;

public class FixedParkingPricingStrategy implements ParkingPricingStrategy {

    private static final double FIXED_RATE = 100.0;

    @Override
    public double calculate(Ticket ticket) {
        if (ticket == null) {
            return 0.0;
        }
        return FIXED_RATE;
    }
}
