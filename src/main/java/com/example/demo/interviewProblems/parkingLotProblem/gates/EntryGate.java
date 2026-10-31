package com.example.demo.interviewProblems.parkingLotProblem.gates;

import com.example.demo.interviewProblems.parkingLotProblem.Ticket;
import com.example.demo.interviewProblems.parkingLotProblem.entity.Vehicle;
import com.example.demo.interviewProblems.parkingLotProblem.parking.ParkingBuilding;

public class EntryGate {
    
    public Ticket enter(ParkingBuilding parkingBuilding,Vehicle vehicle)
    {
       return parkingBuilding.allocate(vehicle);
    }
}
