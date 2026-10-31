package com.example.demo.interviewProblems.parkingLotProblem.parking;

import java.util.Map;

import com.example.demo.interviewProblems.parkingLotProblem.entity.ParkingSpot;
import com.example.demo.interviewProblems.parkingLotProblem.enums.VehicleType;
import com.example.demo.interviewProblems.parkingLotProblem.parkingManager.ParkingSpotManager;

public class ParkingLevel {
    int parkingLevel;
    Map<VehicleType, ParkingSpotManager> managers;

    public ParkingLevel(int parkingLevel, Map<VehicleType, ParkingSpotManager> managers)
    {
        this.parkingLevel = parkingLevel;
        this.managers = managers;
    }

    public boolean hasAvailability(VehicleType vehicleType)
    {
        ParkingSpotManager manager = managers.get(vehicleType);
        return manager!=null && manager.hasFreeSpot();
    }

    public ParkingSpot park(VehicleType vehicleType)
    {
        ParkingSpotManager manager = managers.get(vehicleType);
        if(manager == null)
        {
            throw new IllegalArgumentException(
                "No parking manager for vehicle type: " + vehicleType);
        }
        return manager.park();

    }

    public void unpark(VehicleType vehicleType, ParkingSpot parkingSpot)
    {
        ParkingSpotManager manager = managers.get(vehicleType);
        if(manager == null)
        {
            throw new IllegalArgumentException(
                "No parking manager for vehicle type: " + vehicleType);
        }
        manager.unpark(parkingSpot);
    }

    public int getParkingLevel()
    {
        return parkingLevel;
    }
    
}
