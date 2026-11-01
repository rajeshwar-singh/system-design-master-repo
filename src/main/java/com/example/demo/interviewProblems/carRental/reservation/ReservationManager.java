package com.example.demo.interviewProblems.carRental.reservation;

import com.example.demo.interviewProblems.carRental.enums.ReservationStatus;
import com.example.demo.interviewProblems.carRental.enums.ReservationType;
import com.example.demo.interviewProblems.carRental.user.User;
import com.example.demo.interviewProblems.carRental.vehicle.VehicleInventoryManager;

import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationRepository reservationRepository;
    private final AtomicInteger reservationIdGenerator = new AtomicInteger(20000);

    public ReservationManager(VehicleInventoryManager vehicleInventoryManager)
    {
        this.vehicleInventoryManager = vehicleInventoryManager;
        this.reservationRepository = new ReservationRepository();
        this.vehicleInventoryManager.setReservationRepository(reservationRepository);

    }

    //get reservations
    public Optional<Reservation> getReservations(int reservationId)
    {
        return reservationRepository.findById(reservationId);
    }

    //create reservations
    public Reservation createReservation(int vehicleId, User user, LocalDate from, LocalDate to, ReservationType reservationType) throws Exception
    {
        int reservationId = reservationIdGenerator.getAndIncrement();
        boolean reserved = vehicleInventoryManager.reverse(vehicleId, reservationId, from, to);

        if(!reserved){
            throw new RuntimeException("Vehicle now available for selected dates");
        }

        Reservation reservation = new Reservation(reservationId,vehicleId, user.getUserId(), from, to,reservationType);
        reservationRepository.save(reservation);
        return reservation;
    }


    public void cancelReservation(int reservationId)
    {
        Optional<Reservation>  reservation = reservationRepository.findById(reservationId);
        if(!reservation.isPresent())
        {
            throw new RuntimeException("Reservation not found");
        }
        reservation.get().setReservationStatus(ReservationStatus.CANCELLED);

        vehicleInventoryManager.release(reservation.get().getVehicleId(), reservation.get().getReservationId());
        reservationRepository.removeReservation(reservation.get().getReservationId());
    }

    public void startTrip(int reservationId)
    {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(()-> new RuntimeException("Reservation not found"));

        reservation.setReservationStatus(ReservationStatus.IN_USE);
    }

    public void submitVehicle(int reservationId)
    {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(()-> new RuntimeException("Reservation not found"));
        reservation.setReservationStatus(ReservationStatus.COMPLETED);

        vehicleInventoryManager.release(reservation.getVehicleId(), reservationId);
    }

    public void removeReservation(int reservationId)
    {
        reservationRepository.removeReservation(reservationId);
    }

}
