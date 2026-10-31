package com.example.demo.interviewProblems.parkingLotProblem.parkingManager;

import com.example.demo.interviewProblems.parkingLotProblem.entity.ParkingSpot;
import com.example.demo.interviewProblems.parkingLotProblem.parkingStrategy.ParkingSpotStrategy;
import java.util.*;
public class TwoWheelerParkingSpotManager extends ParkingSpotManager{

    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotStrategy parkingSpotStrategy)
    {
        super(parkingSpots, parkingSpotStrategy);
    }
    
}
