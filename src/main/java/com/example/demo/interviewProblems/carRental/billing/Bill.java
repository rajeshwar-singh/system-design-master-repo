package com.example.demo.interviewProblems.carRental.billing;

public class Bill {
    private int billId;
    private int reservationId;
    private double totalBillAmount;
    private boolean isBillPaid;

    public Bill(int billId, int reservationId, double totalBillAmount)
    {
        this.billId = billId;
        this.reservationId = reservationId;
        this.totalBillAmount = totalBillAmount;
        this.isBillPaid = false;

    }


    public int getBillId() {
        return billId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public boolean isBillPaid() {
        return isBillPaid;
    }

    public void setBillPaid(boolean billPaid)
    {
        this.isBillPaid = billPaid;
    }
}
