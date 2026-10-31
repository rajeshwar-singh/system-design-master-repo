package com.example.demo.interviewProblems.elevatorDesignProblem;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

import com.example.demo.interviewProblems.elevatorDesignProblem.enums.ElevatorDirection;

public class ElevatorController implements Runnable {

    ElevatorCar elevatorCar;

    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;

    private final Object monitor = new Object();

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void submitRequest(int destinationFloor) {
        enqueueRequest(destinationFloor);
    }

    public void enqueueRequest(int destinationFloor)
    {
        System.out.println("Request details -> destination floor : "+ destinationFloor
            +"accepted by elevetor : " + elevatorCar.elevatorId
        );

        if(destinationFloor == elevatorCar.nextFloorStoppage)
        {
            return;
        }
        if(destinationFloor>= elevatorCar.nextFloorStoppage)
        {
            if(!upMinPQ.contains(destinationFloor))
            {
                upMinPQ.add(destinationFloor);
            }
        }
        else{
            if(!downMaxPQ.contains(destinationFloor))
            {
                downMaxPQ.add(destinationFloor);
            }
        }
        synchronized(monitor)
        {
            monitor.notify();
        }
         
    }
    

    @Override 
    public void run()
    {
        controlElevator();
    }

    public void controlElevator()
    {
        while(true)
        {
            synchronized(monitor)
            {
                while(upMinPQ.isEmpty() && downMaxPQ.isEmpty())
                {
                    try{
                        System.out.println("Elevator : " +elevatorCar.elevatorId + " is IDLE");
                        elevatorCar.elevatorDirection = ElevatorDirection.IDLE;
                        monitor.wait();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            while(!upMinPQ.isEmpty())
            {
                int destinationFloor = upMinPQ.poll();
                System.out.println("Serving floor: " + destinationFloor + " by elevator:" + elevatorCar.elevatorId + " currentFloor: " + elevatorCar.currentFloor);
                elevatorCar.moveElevator(destinationFloor);
            }

            while(!downMaxPQ.isEmpty())
                {
                    int destinationFloor = downMaxPQ.poll();
                    System.out.println("Serving floor: " + destinationFloor + " by elevator:" + elevatorCar.elevatorId + " currentFloor: " + elevatorCar.currentFloor);
                    elevatorCar.moveElevator(destinationFloor);
                }
        }
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public int getUpMinPqSize()
    {
        return upMinPQ.size();
    }

    public int getDownMaxPqSize()
    {
        return downMaxPQ.size();
    
    }

}