package elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import scheduler.scheduler;

public class elevator implements Runnable {
    private int speed;
    private int waitTime ;
    private int currentFloor;
    private List<request> schedule;
    private List<request> remainFloors=new ArrayList<request>();
    private scheduler scheduler=new scheduler();

    private int floorsCount;

    private Thread doScheduleThread=new Thread(this);

    private elevatorDirection direction= elevatorDirection.STAND;
    public elevator(int speed,int waitTime ,int currentFloor,int floorsCount){
        this.speed=speed;
        this.waitTime=waitTime;
        this.currentFloor=currentFloor;
        this.floorsCount=floorsCount;
    }
    public boolean go(int destinationFloor){
        if(destinationFloor<1||destinationFloor>floorsCount)return false;

        if (currentFloor<destinationFloor){//go up
            this.direction=direction.UP;
            while (currentFloor<destinationFloor) {
                try {
                    Thread.sleep((long) speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentFloor++;
                System.out.println("floor:"+currentFloor);

            }
        }
        if (currentFloor>destinationFloor){//go down
            this.direction=direction.DOWN;
            while (currentFloor>destinationFloor) {
                try {
                    Thread.sleep((long) speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentFloor--;
                System.out.println("floor:"+currentFloor);

            }

        }
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void doSchedule(List<request> schedule){
        doScheduleThread.stop();
        this.schedule=schedule;
        doScheduleThread=new Thread(this);
        doScheduleThread.start();
    }

    @Override
    public void run() {
        remainFloors.clear();
        remainFloors.addAll(schedule);
        for(request r:schedule){
            go(r.getFloor());
            remainFloors.remove(r);
        }
    }

    public elevatorDirection getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        int floor;
        while (true){
            floor=scanner.nextInt();
            go(floor);
        }
    }
    public void pressKey(List<request> requests) {
        remainFloors.addAll(requests);
        doSchedule(scheduler.schedule(remainFloors,currentFloor,direction));
    }
}
