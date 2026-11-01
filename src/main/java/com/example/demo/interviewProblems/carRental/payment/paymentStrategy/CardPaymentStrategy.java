package com.example.demo.interviewProblems.carRental.payment.paymentStrategy;

import com.example.demo.interviewProblems.carRental.billing.Bill;
import com.example.demo.interviewProblems.carRental.payment.Payment;
import com.example.demo.interviewProblems.carRental.payment.PaymentIdGenerator;
import com.example.demo.interviewProblems.carRental.payment.PaymentMode;

import java.util.Date;

public class CardPaymentStrategy implements PaymentStrategy{

    @Override
    public Payment processPayment(Bill bill, double paymentAmount)
    {

        Payment payment = new Payment(PaymentIdGenerator.generatePaymentId(),
                bill.getBillId(), paymentAmount, PaymentMode.CARD, new Date());

        bill.setBillPaid(true);
        return payment;
    }
}
