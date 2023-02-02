import elevator.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import elevator.request;

public class main {
    public static void main(String[] args) {
        elevator e1 = new elevator(1000,2000,5,15);
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
            e1.pressKey(r);
        }

    }
}
