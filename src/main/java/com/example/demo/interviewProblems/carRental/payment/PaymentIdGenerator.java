package com.example.demo.interviewProblems.carRental.payment;

import java.util.concurrent.atomic.AtomicInteger;

public class PaymentIdGenerator {

    private final static AtomicInteger paymentId = new AtomicInteger(90);
    public static int generatePaymentId()
    {
        return paymentId.getAndIncrement();
    }
}
