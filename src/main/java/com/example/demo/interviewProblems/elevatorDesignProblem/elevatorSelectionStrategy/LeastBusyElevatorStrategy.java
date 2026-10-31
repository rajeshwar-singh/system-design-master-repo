package com.example.demo.interviewProblems.elevatorDesignProblem.elevatorSelectionStrategy;

import com.example.demo.interviewProblems.elevatorDesignProblem.ElevatorController;

public class LeastBusyElevatorStrategy implements ElevatorSelectionStrategy {

    @Override 
    public ElevatorController selectElevator(List<ElevatorController> controllers,
        int requestFloor, 
        ElevatorDirection elevatorDirection)
        {
            ElevatorController best = null;
            int minLoad = Integer.MAX_VALUE;

            for(ElevatorController controller : controllers)
            {
                int load = controller.getUpMinPqSize() +
                    controller.getDownMaxPqSize();
                    if (load < minLoad) {
                        minLoad = load;
                        best = controller;
                    }
            }
            return best;
        }
}