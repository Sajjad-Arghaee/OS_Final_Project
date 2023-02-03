package elevator;

import java.util.Date;

public class request {
    private int floor;
    private final long date = new Date().getTime();
    private char requestType;

    public request(int floor,char requestType){
        this.floor = floor;
        this.requestType=requestType;
    }

    public int getFloor() {
        return floor;
    }

    public long requestTime(){
        return date;
    }

    public char getRequestType() {
        return requestType;
    }
}
