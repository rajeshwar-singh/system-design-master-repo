package com.example.demo.interviewProblems.carRental.billing.billingStrategy;

import com.example.demo.interviewProblems.carRental.billing.Bill;
import com.example.demo.interviewProblems.carRental.billing.BillIdGenerator;
import com.example.demo.interviewProblems.carRental.reservation.Reservation;
import com.example.demo.interviewProblems.carRental.vehicle.Vehicle;
import com.example.demo.interviewProblems.carRental.vehicle.VehicleInventoryManager;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DailyBillingStrategy implements BillingStrategy {

    VehicleInventoryManager vehicleInventoryManager;

    public DailyBillingStrategy(VehicleInventoryManager vehicleInventoryManager)
    {
        this.vehicleInventoryManager = vehicleInventoryManager;
    }
    @Override
    public Bill generateBill(Reservation reservation)
    {
        long days = ChronoUnit.DAYS.between(
                reservation.getDateBookedFrom(),
                reservation.getDateBookedTo()
        )+1;

        Vehicle vehicle = vehicleInventoryManager.getVehicle(reservation.getVehicleId()).get();
        double rate = vehicle.getDailyRentalCost();
        double total = days * rate;

        return new Bill(BillIdGenerator.generateId(), reservation.getReservationId(), total);
    }
}
