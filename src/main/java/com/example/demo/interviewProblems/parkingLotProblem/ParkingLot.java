package com.example.demo.interviewProblems.parkingLotProblem;


import com.example.demo.interviewProblems.parkingLotProblem.entity.Vehicle;
import com.example.demo.interviewProblems.parkingLotProblem.gates.EntryGate;
import com.example.demo.interviewProblems.parkingLotProblem.gates.ExitGate;
import com.example.demo.interviewProblems.parkingLotProblem.parking.ParkingBuilding;
import com.example.demo.interviewProblems.parkingLotProblem.payment.PaymentStrategy;

public class ParkingLot {
    private final ParkingBuilding parkingBuilding;
    private final EntryGate entryGate;
    private final ExitGate exitGate;

    public ParkingLot(ParkingBuilding parkingBuilding, EntryGate entryGate, ExitGate exitGate)
    {
        this.parkingBuilding = parkingBuilding;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle)
    {
        return entryGate.enter(parkingBuilding, vehicle);
    }

    public void vehicleLeaves(Ticket ticket, PaymentStrategy payment)
    {
        exitGate.exit(parkingBuilding, ticket, payment);
    }
}
