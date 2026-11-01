package com.example.demo.interviewProblems.carRental;

import com.example.demo.interviewProblems.carRental.billing.Bill;
import com.example.demo.interviewProblems.carRental.billing.BillingManager;
import com.example.demo.interviewProblems.carRental.billing.billingStrategy.BillingStrategy;
import com.example.demo.interviewProblems.carRental.billing.billingStrategy.DailyBillingStrategy;
import com.example.demo.interviewProblems.carRental.billing.billingStrategy.HourlyBillingStrategy;
import com.example.demo.interviewProblems.carRental.enums.ReservationType;
import com.example.demo.interviewProblems.carRental.enums.VehicleType;
import com.example.demo.interviewProblems.carRental.payment.Payment;
import com.example.demo.interviewProblems.carRental.payment.PaymentManager;
import com.example.demo.interviewProblems.carRental.payment.paymentStrategy.PaymentStrategy;
import com.example.demo.interviewProblems.carRental.payment.paymentStrategy.UPIPaymentStrategy;
import com.example.demo.interviewProblems.carRental.reservation.Reservation;
import com.example.demo.interviewProblems.carRental.reservation.ReservationManager;
import com.example.demo.interviewProblems.carRental.user.User;
import com.example.demo.interviewProblems.carRental.utils.Location;
import com.example.demo.interviewProblems.carRental.vehicle.Vehicle;
import com.example.demo.interviewProblems.carRental.vehicle.VehicleInventoryManager;

import java.time.LocalDate;
import java.util.List;

public class Store {
    private final int storeId;
    private final Location location;
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final BillingManager billingManager;
    private final PaymentManager paymentManager;


    public Store(int storeId, Location location)
    {
        this.storeId = storeId;
        this.location = location;
        this.vehicleInventoryManager = new VehicleInventoryManager();
        this.reservationManager = new ReservationManager(vehicleInventoryManager);
        this.billingManager = new BillingManager(new HourlyBillingStrategy());
        this.paymentManager = new PaymentManager(new UPIPaymentStrategy());
    }

    // ----------------- Search Vehicles --------------------
    public List<Vehicle> getVehicles(VehicleType vehicleType, LocalDate from, LocalDate to)
    {
        return vehicleInventoryManager.getAvailableVehicles(vehicleType, from, to);
    }

    // ----------------- Create Reservation -----------------
    public Reservation createReservation(int vehicleId, User user, LocalDate from,
                                         LocalDate to, ReservationType reservationType) throws Exception
    {
       return reservationManager.createReservation(vehicleId,user,from,to,reservationType);
    }

    // ----------------- Update Reservation -----------------
    public void cancelReservation(int reservationId)
    {
        reservationManager.cancelReservation(reservationId);
    }

    public void startTrip(int reservationId) {
        reservationManager.startTrip(reservationId);
    }

    public void submitVehicle(int reservationId) {
        reservationManager.submitVehicle(reservationId);
    }

    // ----------------- Billing & Payment ------------------

    public Bill generateBill(int reservationId, BillingStrategy billingStrategy) {
        Reservation r = reservationManager.getReservations(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        billingManager.setBillingStrategy(billingStrategy);
        return billingManager.generateBill(r);
    }


    public Payment makePayment(Bill bill, PaymentStrategy paymentStrategy, double paymentAmount) {

        paymentManager.setPaymentStrategy(paymentStrategy);
        Payment payment = paymentManager.makePayment(bill, paymentAmount);

        if (!bill.isBillPaid()) {
            throw new RuntimeException("Payment failed");
        }

        // NOW we can safely remove the reservation from the repo
        reservationManager.removeReservation(bill.getReservationId());
        return payment;
    }

    public VehicleInventoryManager getInventory() {
        return vehicleInventoryManager;
    }

    public int getStoreId() {
        return storeId;
    }
}
