package com.example.demo.interviewProblems.carRental.billing.billingStrategy;

import com.example.demo.interviewProblems.carRental.billing.Bill;
import com.example.demo.interviewProblems.carRental.billing.BillIdGenerator;
import com.example.demo.interviewProblems.carRental.reservation.Reservation;
import com.example.demo.interviewProblems.carRental.pricing.PricingConstants;

import java.time.temporal.ChronoUnit;

public class HourlyBillingStrategy implements BillingStrategy{

    @Override
    public Bill generateBill(Reservation reservation)
    {
        long hours = ChronoUnit.HOURS.between(
                reservation.getDateBookedFrom(),
                reservation.getDateBookedTo()
        )+1;

        double total = hours * PricingConstants.HOURLY_RATE;

        return new Bill(BillIdGenerator.generateId(), reservation.getReservationId(), total);


    }
}
