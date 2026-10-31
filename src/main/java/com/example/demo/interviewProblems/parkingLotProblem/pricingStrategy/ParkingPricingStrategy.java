package com.example.demo.interviewProblems.parkingLotProblem.pricingStrategy;

import com.example.demo.interviewProblems.parkingLotProblem.Ticket;

public interface ParkingPricingStrategy {
    double calculate(Ticket ticket);
}
