package com.example.demo.interviewProblems.elevatorDesignProblem.buttons;

import com.example.demo.interviewProblems.elevatorDesignProblem.enums.ElevatorDirection;

public class ExternalButton
{
    private final ExternalDispatcher externalDispatcher;
    public ExternalButton(ExternalDispatcher externalDispatcher)
    {
        this.externalDispatcher = externalDispatcher;
    }

     // this direction of external button is only helpful in selecting the correct elevator
     public void pressButton(int floor, ElevatorDirection direction)
     {
        externalDispatcher.submitExternalRequest(floor, direction);
     }
}