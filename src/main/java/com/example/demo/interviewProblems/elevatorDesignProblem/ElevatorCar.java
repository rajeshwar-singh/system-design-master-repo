package com.example.demo.interviewProblems.elevatorDesignProblem;

import com.example.demo.interviewProblems.elevatorDesignProblem.enums.ElevatorDirection;

public class ElevatorCar{
    int elevatorId;
    int currentFloor;
    int nextFloorStoppage;
    ElevatorDirection elevatorDirection;
    Door door;

    public ElevatorCar(int elevatorId)
    {
        this.elevatorId = elevatorId;
        currentFloor = 0;
        elevatorDirection = ElevatorDirection.IDLE;
        door = new Door();
    }

    public void showDisplay()
    {
        System.out.println("Elevator id : " + elevatorId+ " Current Floor : " + currentFloor
            + " Elevator Direction : " + elevatorDirection
        );
    }

    public void moveElevator(int destinationFloor)
    {
        this.nextFloorStoppage = destinationFloor;
        if(currentFloor == nextFloorStoppage)
        {
            door.openDoor(elevatorId);
            return;
        }

        int startFloor = currentFloor;
        door.closeDoor(startFloor);

        if(nextFloorStoppage>=currentFloor)
        {
            elevatorDirection = ElevatorDirection.UP;
            showDisplay();

            for(int i = startFloor + 1; i<=nextFloorStoppage; i++)
            {
                try{
                    Thread.sleep(5);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        else{
            elevatorDirection = ElevatorDirection.DOWN;
            showDisplay();

            for(int i = startFloor - 1; i>-nextFloorStoppage; i--)
            {
                try{
                    Thread.sleep(5);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        door.openDoor(elevatorId);
    }

    public void setCurrentFloor(int currentFloor)
    {
        this.currentFloor = currentFloor;
    }
    
    public int getNextFloorStoppage() {
        return nextFloorStoppage;
    }
    public ElevatorDirection getElevatorDirection()
    {
        return elevatorDirection;
    }
}
