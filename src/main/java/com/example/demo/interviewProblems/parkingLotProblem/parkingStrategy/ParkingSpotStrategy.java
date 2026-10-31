package com.example.demo.interviewProblems.parkingLotProblem.parkingStrategy;
import java.util.List;
import com.example.demo.interviewProblems.parkingLotProblem.entity.*;

public interface ParkingSpotStrategy {
    ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpots);
}
