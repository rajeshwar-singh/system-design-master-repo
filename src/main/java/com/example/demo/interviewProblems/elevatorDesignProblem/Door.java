package com.example.demo.interviewProblems.elevatorDesignProblem;
import com.exmaple.demo.interviewProblems.enums;
public class Door{
    private DoorState doorState;

    public Door()
    {
        doorState = DoorState.DOOR_CLOSED;

    }

    public void openDoor(int elevatorId)
    {
        doorState = DoorState.DOOR_OPEN;
        System.out.println("Opening the elevator door of elevator : "+ elevatorId);
    }

    public void closeDoor(int elevatorId)
    {
        doorState = DoorState.DOOR_CLOSED;
        System.out.println("Closing the elevator door of elevator : "+ elevatorId);
    }
    
}