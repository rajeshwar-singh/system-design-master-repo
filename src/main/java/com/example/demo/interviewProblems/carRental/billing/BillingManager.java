package com.example.demo.interviewProblems.carRental.billing;

import com.example.demo.interviewProblems.carRental.billing.billingStrategy.BillingStrategy;
import com.example.demo.interviewProblems.carRental.reservation.Reservation;
import jakarta.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BillingManager {

    private BillingStrategy billingStrategy;

    private final Map<Integer, Bill> bills = new HashMap<>();

    public BillingManager(BillingStrategy billingStrategy)
    {
        this.billingStrategy = billingStrategy;
    }

    public Bill generateBill(Reservation reservation)
    {
        Bill bill = billingStrategy.generateBill(reservation);
        bills.put(bill.getBillId(), bill);
        return bill;
    }

    public Optional<Bill> getBill(int billId)
    {
        return Optional.ofNullable(bills.get(billId));
    }

    public void setBillingStrategy(BillingStrategy billingStrategy)
    {
        this.billingStrategy = billingStrategy;
    }
}
