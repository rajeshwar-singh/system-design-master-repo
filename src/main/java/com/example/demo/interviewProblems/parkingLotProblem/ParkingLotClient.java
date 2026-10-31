package com.example.demo.interviewProblems.parkingLotProblem;

import com.example.demo.interviewProblems.parkingLotProblem.parkingStrategy.ParkingSpotStrategy;
import com.example.demo.interviewProblems.parkingLotProblem.parkingStrategy.RandomParkingSpotStrategy;
import com.example.demo.interviewProblems.parkingLotProblem.payment.CashPayment;
import com.example.demo.interviewProblems.parkingLotProblem.payment.UPIPayment;
import com.example.demo.interviewProblems.parkingLotProblem.pricingStrategy.CostComputation;
import com.example.demo.interviewProblems.parkingLotProblem.pricingStrategy.HourlyParkingPricingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.interviewProblems.parkingLotProblem.entity.ParkingSpot;
import com.example.demo.interviewProblems.parkingLotProblem.entity.Vehicle;
import com.example.demo.interviewProblems.parkingLotProblem.enums.VehicleType;
import com.example.demo.interviewProblems.parkingLotProblem.gates.EntryGate;
import com.example.demo.interviewProblems.parkingLotProblem.gates.ExitGate;
import com.example.demo.interviewProblems.parkingLotProblem.parking.ParkingBuilding;
import com.example.demo.interviewProblems.parkingLotProblem.parking.ParkingLevel;
import com.example.demo.interviewProblems.parkingLotProblem.parkingManager.*;
public class ParkingLotClient{
    public void startParkingLotClient()
    {
        ParkingSpotStrategy parkingSpotStrategy = new RandomParkingSpotStrategy();
        

        Map<VehicleType, ParkingSpotManager> levelOneManagers = new HashMap<>();

        levelOneManagers.put(VehicleType.TWO_WHEELER, new TwoWheelerParkingSpotManager(List.of(new ParkingSpot("L1-S1"),
            new ParkingSpot("L1-S2")),parkingSpotStrategy));
        levelOneManagers.put(VehicleType.FOUR_WHEELER, new FourWheelerParkingSpotManager(List.of(new ParkingSpot("L1-S3"),
            new ParkingSpot("L1-S4")),parkingSpotStrategy));

        ParkingLevel parkingLevel1 = new ParkingLevel(1,levelOneManagers);


        Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();

        levelTwoManagers.put(VehicleType.TWO_WHEELER, new TwoWheelerParkingSpotManager(List.of(new ParkingSpot("L2-S1"),
            new ParkingSpot("L2-S2")),parkingSpotStrategy));
        levelTwoManagers.put(VehicleType.FOUR_WHEELER, new FourWheelerParkingSpotManager(List.of(new ParkingSpot("L2-S3"),
            new ParkingSpot("L2-S4")),parkingSpotStrategy));

        ParkingLevel parkingLevel2 = new ParkingLevel(2, levelTwoManagers);

        ParkingBuilding building = new ParkingBuilding(List.of(parkingLevel1, parkingLevel2));


        ParkingLot parkingLot = new ParkingLot(building, new EntryGate(), new ExitGate(new CostComputation(new HourlyParkingPricingStrategy())));


        //adding vehicles to parking lot
        Vehicle car1 = new Vehicle("UP 65 CZ 8878", VehicleType.FOUR_WHEELER);
        Vehicle bike1 = new Vehicle("UP 65 AY 2874", VehicleType.TWO_WHEELER);

        Ticket t1 = parkingLot.vehicleArrives(car1);
        Ticket t2 = parkingLot.vehicleArrives(bike1);

        parkingLot.vehicleLeaves(t1, new CashPayment());
        parkingLot.vehicleLeaves(t2, new UPIPayment());


    

        
    }
}