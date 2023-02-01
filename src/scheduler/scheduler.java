package scheduler;

import elevator.elevatorDirection;

import java.util.ArrayList;
import java.util.List;
import elevator.request;

public class scheduler {
    public scheduler(){}
    

    public List<request> schedule(List<request> floors, int currentFloor, elevatorDirection ed){
        List<request> schedule = new ArrayList<>();

        //for test
        for(request r:floors){
            schedule.add(r);
        }

        return schedule;
    }

}
