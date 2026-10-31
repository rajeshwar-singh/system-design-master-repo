package com.example.demo.interviewProblems.parkingLotProblem.parkingStrategy;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.example.demo.interviewProblems.parkingLotProblem.entity.ParkingSpot;


public class RandomParkingSpotStrategy implements ParkingSpotStrategy {

    @Override 
    public ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots)
    {
        if(parkingSpots == null || parkingSpots.isEmpty())
        {
            return null;
        }

        //filtering the spots that are actually free..
        @SuppressWarnings("null")
        List<ParkingSpot> freeSpots = parkingSpots.stream()
                                                    .filter(ParkingSpot::isSpotFree)
                                                    .collect(Collectors.toList());

        if(freeSpots.isEmpty())
        {
            return null;
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(freeSpots.size());
        return  freeSpots.get(randomIndex);
    }
    
}
