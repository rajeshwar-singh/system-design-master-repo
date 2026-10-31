package com.example.demo.interviewProblems.elevatorDesignProblem.buttons;

import com.example.demo.interviewProblems.elevatorDesignProblem.ElevatorController;
import com.example.demo.interviewProblems.elevatorDesignProblem.ElevatorScheduler;

public class ExternalDispatcher
{
    ElevatorScheduler elevatorScheduler;

    public ExternalDispatcher(ElevatorScheduler elevatorScheduler)
    {
        this.elevatorScheduler = elevatorScheduler;
    }

    public void submitExternalRequest(int floor, ElevatorDirection direction)
    {
        ElevatorController controller = elevatorScheduler.assignElevator(floor, direction);
        controller.submitRequest(floor);
    }
}