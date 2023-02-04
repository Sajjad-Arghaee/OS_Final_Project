import elevator.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import elevator.request;
import elevator.elevatorDirection;
import scheduler.scheduler;

public class main {
    public static void main(String[] args) {
        elevator e1 = new elevator(1000,2000,5,15, 1);
        elevator e2 = new elevator(1000,2000,5,15, 2);
        elevator e3 = new elevator(1000,2000,5,15, 3);
        Scanner scanner = new Scanner(System.in);
        int keyPressed;
        List<request> r = new ArrayList<>();
        while (true){
            while (true) {
                keyPressed= scanner.nextInt();
                if (keyPressed == -1)
                    break;
                r.add(new request(keyPressed, 'i'));
            }
            List<Object> result = e1.pressKey(r);
//            List<Object> result2 = e2.pressKey(r);
//            List<Object> result3 = e3.pressKey(r);
//            List<request> remainFloors = (List<request>) result.get(0);
//            int currentFloor = (int) result.get(1);
//            elevatorDirection direction = (elevatorDirection) result.get(2);
//            List<request> res1 = new scheduler().schedule(remainFloors,currentFloor,direction);
            r.clear();
        }

    }
}
