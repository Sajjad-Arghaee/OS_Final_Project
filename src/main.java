import elevator.elevator;

import javax.swing.*;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import elevator.request;

public class main {
    public static void main(String[] args) {
        elevator e1 = new elevator(1000,2000,5,15);
        Scanner scanner = new Scanner(System.in);
        int keyPressed;
        while (true){
            keyPressed=scanner.nextInt();
            request r=new request(keyPressed,'i');
            e1.pressKey(r);
        }

    }
}
