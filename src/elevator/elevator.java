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

    public List go(int destinationFloor){
        if(destinationFloor<1||destinationFloor>floorsCount)return null;

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
        List<request> r = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int keyPressed;
        while (true) {
            keyPressed= scanner.nextInt();
            if (keyPressed == -1)
                break;
            r.add(new request(keyPressed, 'i'));
        }
        return r;
    }

    public void doSchedule(List<request> schedule){
        this.schedule=schedule;
        doScheduleThread=new Thread(this::run);
        doScheduleThread.start();
        try {
            doScheduleThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        remainFloors.clear();
        remainFloors.addAll(schedule);
        List<request> inner_requests = null;
        boolean state = false;
        for(request r:schedule){
            inner_requests = go(r.getFloor());
            remainFloors.remove(r);
            remainFloors.addAll(inner_requests);
            if (inner_requests.size() > 0) {
                state = true;
                break;
            }
        }
        List<request> new_requests = remainFloors;
        if (state)
            pressKey(new_requests);

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
        remainFloors = requests;
        doSchedule(scheduler.schedule(remainFloors,currentFloor,direction));
    }
}
