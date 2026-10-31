package com.example.demo.interviewProblems.parkingLotProblem;

import java.time.LocalDateTime;

import com.example.demo.interviewProblems.parkingLotProblem.entity.ParkingSpot;
import com.example.demo.interviewProblems.parkingLotProblem.entity.Vehicle;
import com.example.demo.interviewProblems.parkingLotProblem.parking.ParkingLevel;

public class Ticket {
    private final Vehicle vehicle;
    private final ParkingLevel parkingLevel;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot parkingSpot)
    {
        this.vehicle = vehicle;
        this.parkingLevel = parkingLevel;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public ParkingLevel getParkingLevel()
    {
        return parkingLevel;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public ParkingSpot getParkingSpot()
    {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime()
    {
        return entryTime;
    }
    
}
