package com.example.demo.interviewProblems.parkingLotProblem.pricingStrategy;

import com.example.demo.interviewProblems.parkingLotProblem.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyParkingPricingStrategy implements ParkingPricingStrategy {

    @Override
    public double calculate(Ticket ticket) {
        if (ticket == null || ticket.getEntryTime() == null) {
            // Or throw an IllegalArgumentException
            return 0.0;
        }

        LocalDateTime exitTime = LocalDateTime.now();
        if (ticket.getEntryTime().isAfter(exitTime)) {

            return 0.0;
        }

        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);

        long minutes = duration.toMinutes();
        long hours = (minutes + 59) / 60;

        return hours * 10.0;
    }
}
