package com.example.demo.interviewProblems.carRental.payment.paymentStrategy;

import com.example.demo.interviewProblems.carRental.billing.Bill;
import com.example.demo.interviewProblems.carRental.payment.Payment;

public interface PaymentStrategy {

    Payment processPayment(Bill bill, double paymentAmount);
}
