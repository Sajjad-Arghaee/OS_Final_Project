package scheduler;

import elevator.elevatorDirection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import elevator.request;

public class scheduler {
    private int direction_score = 1;
    public scheduler(){}
    

    public List<request> schedule(List<request> floors, int currentFloor, elevatorDirection ed){
        List<request> schedule = new ArrayList<>();
        List<Long> scores = new ArrayList<>();
        long current_time = new Date().getTime();


        //for test
        for(request r:floors){
            long current_score = 0;
            current_score += current_time-r.requestTime();
            if ((r.getFloor() > currentFloor) && ed.equals(elevatorDirection.UP))
                current_score += direction_score;
            else if ((r.getFloor() < currentFloor) && ed.equals(elevatorDirection.DOWN))
                current_score += direction_score;
            scores.add(current_score);
        }
        while (!scores.isEmpty()) {
            int current_max_index = 0;
            long current_max_score = -1;
            for (int index=0;index<scores.size();index++) {
                if (scores.get(index) > current_max_score){
                    current_max_score = scores.get(index);
                    current_max_index = index;
                }
            schedule.add(floors.get(current_max_index));
            scores.remove(current_max_index);
            }
        }

        for (request s:schedule){
            System.out.print(s.getFloor());
            System.out.println(" ");
        }
        System.out.println();
        return schedule;
    }

}
