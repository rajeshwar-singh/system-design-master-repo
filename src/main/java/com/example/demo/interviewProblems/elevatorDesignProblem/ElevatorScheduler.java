package com.example.demo.interviewProblems.elevatorDesignProblem;

import com.example.demo.interviewProblems.elevatorDesignProblem.elevatorSelectionStrategy.ElevatorSelectionStrategy;
import com.example.demo.interviewProblems.elevatorDesignProblem.enums.ElevatorDirection;

import java.util.List;

public class ElevatorScheduler{
    private final List<ElevatorController> controllers;
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ElevatorScheduler(List<ElevatorController> controllers, ElevatorSelectionStrategy elevatorSelectionStrategy)
    {
        this.controllers = controllers;
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }

    public void setStrategy(ElevatorSelectionStrategy strategy)
    {
        this.elevatorSelectionStrategy = strategy;
    }

    public ElevatorController assignElevator(int floor, ElevatorDirection direction)
    {
        return elevatorSelectionStrategy.selectElevator(controllers, floor, direction);
    }
}