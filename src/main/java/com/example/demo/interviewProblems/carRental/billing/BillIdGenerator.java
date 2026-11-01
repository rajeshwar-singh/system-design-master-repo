package com.example.demo.interviewProblems.carRental.billing;

import java.util.concurrent.atomic.AtomicInteger;

public class BillIdGenerator {

    private static final AtomicInteger counter = new AtomicInteger(9000);
    public static int generateId()
    {
        return counter.getAndIncrement();
    }
}
