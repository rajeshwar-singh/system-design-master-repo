package com.example.demo.interviewProblems.parkingLotProblem.entity;

public class ParkingSpot {

    private final String parkingSpotId;
    private boolean isFree = true;

    public ParkingSpot(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }
    
    public boolean isSpotFree()
    {
        return isFree;
    }

    public void occupySpot()
    {
        isFree = false;
    }

    public void releaseSpot()
    {
        isFree = true;
    }
 
}
