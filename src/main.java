import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        elevator e1 = new elevator(1000,2000,5,15);
//        elevator e2 = new elevator(1000,2000,5,15);
//        elevator e3 = new elevator(1000,2000,5,15);
//        ArrayList<elevator> elevators=new ArrayList<>();
//        elevators.add(e1);
//        elevators.add(e2);
//        elevators.add(e3);

        Scanner scanner = new Scanner(System.in);
        int keyPressed;
        while (true){
            keyPressed=scanner.nextInt();
            e1.pressKey(keyPressed);
        }

    }
}
