package com.example.demo.interviewProblems.carRental.payment;

import com.example.demo.interviewProblems.carRental.billing.Bill;
import com.example.demo.interviewProblems.carRental.payment.paymentStrategy.PaymentStrategy;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class PaymentManager {

    private final ConcurrentMap<Integer, Payment> payments = new ConcurrentHashMap<>();
    private PaymentStrategy paymentStrategy;

    public PaymentManager(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Payment makePayment(Bill bill, double paymentAmount)
    {
        Payment payment = paymentStrategy.processPayment(bill, paymentAmount);
        payments.put(payment.getPaymentId(), payment);
        return payment;

    }

    public List<Payment> getPaymentsForBills(int billId)
    {
        return payments.values().stream()
                .filter(p->p.getBillId() == billId)
                .collect(Collectors.toList());
    }

    public Optional<Payment> getPayment(int paymentId)
    {
        return Optional.ofNullable(payments.get(paymentId));
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy = paymentStrategy;
    }
}
