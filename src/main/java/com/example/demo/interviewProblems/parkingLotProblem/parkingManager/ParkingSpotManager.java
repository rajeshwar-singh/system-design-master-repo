package com.example.demo.interviewProblems.parkingLotProblem.parkingManager;

import com.example.demo.interviewProblems.parkingLotProblem.entity.ParkingSpot;
import com.example.demo.interviewProblems.parkingLotProblem.parkingStrategy.ParkingSpotStrategy;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public abstract class ParkingSpotManager {

    protected final List<ParkingSpot> parkingSpots;
    protected final ParkingSpotStrategy parkingSpotStrategy;
    private final ReentrantLock lock = new ReentrantLock(true);

    protected ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingSpotStrategy parkingSppSpotStrategy)
    {
        this.parkingSpots = parkingSpots;
        this.parkingSpotStrategy = parkingSppSpotStrategy;
    }

    public ParkingSpot park(){
        lock.lock();
        try{
            ParkingSpot parkingSpot = parkingSpotStrategy.selectParkingSpot(parkingSpots);
            if(parkingSpot == null)
            {
                return null;
            }
            else{
                parkingSpot.occupySpot();
                return parkingSpot;
            }
        }finally{
            lock.unlock();
        }
    }
    public void unpark(ParkingSpot parkingSpot){
        lock.lock();
        try{

            parkingSpot.releaseSpot();
        }
        finally{
            lock.unlock();
        }
    }
    @SuppressWarnings("null")
    public boolean hasFreeSpot(){
        lock.lock();
        try{
            return parkingSpots.stream().anyMatch(ParkingSpot::isSpotFree);
        }
        finally
        {
            lock.unlock();
        }
    }
    
}
