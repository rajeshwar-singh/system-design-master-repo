package com.example.demo.interviewProblems.carRental.billing.billingStrategy;

import com.example.demo.interviewProblems.carRental.billing.Bill;
import com.example.demo.interviewProblems.carRental.reservation.Reservation;

public interface BillingStrategy {

    Bill generateBill(Reservation reservation);
}
