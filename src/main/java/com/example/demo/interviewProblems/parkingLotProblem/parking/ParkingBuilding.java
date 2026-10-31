package com.example.demo.interviewProblems.parkingLotProblem.parking;
import java.util.*;

import com.example.demo.interviewProblems.parkingLotProblem.Ticket;
import com.example.demo.interviewProblems.parkingLotProblem.entity.ParkingSpot;
import com.example.demo.interviewProblems.parkingLotProblem.entity.Vehicle;
public class ParkingBuilding {
    List<ParkingLevel> parkingLevels;

    public ParkingBuilding(List<ParkingLevel> parkingLevels)
    {
        this.parkingLevels = parkingLevels;
    }

    public Ticket allocate(Vehicle vehicle)
    {
        for(ParkingLevel level : parkingLevels)
        {
            if(level.hasAvailability(vehicle.getVehicleType()))
            {
                ParkingSpot parkingSpot = level.park(vehicle.getVehicleType());
                if(parkingSpot!=null)
                {
                    Ticket ticket = new Ticket(vehicle,level, parkingSpot);
                    System.out.println("Parking allocated at level: "
                            + level.getParkingLevel()
                            + " spot: " + parkingSpot.getParkingSpotId());
                    return ticket;
                }
            }
            
        }
        throw new RuntimeException("Parking Full");
    }

    public void release(Ticket ticket)
    {
        ticket.getParkingLevel()
                .unpark(ticket.getVehicle().getVehicleType(), ticket.getParkingSpot());
    }
}
