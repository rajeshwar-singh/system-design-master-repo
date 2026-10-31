package com.example.demo.interviewProblems.elevatorDesignProblem.elevatorSelectionStrategy;
import com.example.demo.interviewProblems.elevatorDesignProblem.ElevatorCar;
import com.example.demo.interviewProblems.elevatorDesignProblem.ElevatorController;
import com.example.demo.interviewProblems.elevatorDesignProblem.enums.ElevatorDirection;
import java.util.List;
public interface ElevatorSelectionStrategy{
    ElevatorController selectElevator(List<ElevatorController> elevatorController, 
        int requestFloor, 
        ElevatorDirection elevatorDirection);
}
