package com.example.demo.interviewProblems.parkingLotProblem.parkingStrategy;
import java.util.List;

import com.example.demo.interviewProblems.parkingLotProblem.entity.ParkingSpot;
public class NormalParkingSpotStrategy implements ParkingSpotStrategy{
    @Override 
    public ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots)
    {
        for(ParkingSpot spot : parkingSpots)
        {
            if(spot.isSpotFree())
            {
                return spot;
            }
        }  
        return null; 
    }
}
