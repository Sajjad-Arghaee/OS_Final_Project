package scheduler;

import elevator.elevatorDirection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import elevator.request;

public class scheduler {
    public scheduler() {
    }

    public List<request> schedule(List<request> floors, int currentFloor, elevatorDirection ed) {
        List<request> schedule = new ArrayList<>();
        List<Long> scores = new ArrayList<>();
        long current_time = new Date().getTime();

        for (request r : floors) {
            long current_score = 0;
            current_score += current_time - r.requestTime();
            if ((r.getFloor() > currentFloor) && ed == elevatorDirection.UP)
                current_score += 10000;
            else if ((r.getFloor() < currentFloor) && ed == elevatorDirection.DOWN)
                current_score += 10000;
            scores.add(current_score);
            current_time -= 1;
        }
        while (!scores.isEmpty()) {
            int current_max_index = 0;
            long current_max_score = -9999;
            for (int index = 0; index < scores.size(); index++) {
                if (scores.get(index) > current_max_score) {
                    current_max_score = scores.get(index);
                    current_max_index = index;
                }

            }
            schedule.add(floors.get(current_max_index));
            floors.remove(current_max_index);
            scores.remove(current_max_index);

        }

//        for (request s:schedule){
//            System.out.print(s.getFloor());
//            System.out.print(" ");
//        }
//        System.out.println();
        return schedule;
    }

}
