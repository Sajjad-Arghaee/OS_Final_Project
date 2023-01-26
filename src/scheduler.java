import java.util.ArrayList;
import java.util.List;

public class scheduler {
    public scheduler(){}
    

    public List<Integer> schedule(List<Integer> floors,int currentFloor,elevatorDirection ed){
        List<Integer> schedule = new ArrayList<>();

        //for test
        for(Integer f:floors){
            schedule.add(f);
        }

        return schedule;
    }

}
