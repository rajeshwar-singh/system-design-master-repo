package com.example.demo.interviewProblems.elevatorDesignProblem.elevatorSelectionStrategy;

import com.example.demo.interviewProblems.elevatorDesignProblem.ElevatorController;
import com.example.demo.interviewProblems.elevatorDesignProblem.enums.ElevatorDirection;
import java.util.*;
public class NearestElevatorStrategy implements ElevatorSelectionStrategy
{
    @Override
    public ElevatorController selectElevator(List<ElevatorController> elevatorControllers,
        int requestFloor, 
        ElevatorDirection elevatorDirection){
            
        ElevatorController best = null;
        int minDistance = Integer.MAX_VALUE;

        //1. Pick the one which is going in same direction and minimum distance from the destination
        for(ElevatorController controller : elevatorControllers)
        {
            int nextFloorStoppage = controller.getElevatorCar().getNextFloorStoppage();

            // Good candidate if moving same direction & not passed requested floor
            boolean isSameDirection = controller.getElevatorCar().getElevatorDirection() == elevatorDirection &&
                ((elevatorDirection == ElevatorDirection.UP && nextFloorStoppage <= requestFloor)
               || (elevatorDirection == ElevatorDirection.DOWN && nextFloorStoppage>=requestFloor));

            int dist = Math.abs(nextFloorStoppage - requestFloor);

            if(isSameDirection && dist < requestFloor)
            {
                minDistance = dist;
                best = controller;
            }
            

        }
        // fallback: if not able to choose, pick the idle one
        if(best == null)
        {
            for(ElevatorController controller : elevatorControllers)
            {
                if(controller.getElevatorCar().getElevatorDirection() == ElevatorDirection.IDLE)
                {
                    best = controller;
                    break;
                }
            }
            //reached here means, no list is going in same direction and no lift is IDLE too, then pick any lift
            if(best == null) {
                best = elevatorControllers.get(0);
            }
        }
        return best;
    }
}