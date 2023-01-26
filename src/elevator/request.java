package elevator;

import java.util.Date;

public class request {
    private int floor;
    private Date date;
    private char requestType;

    public request(int floor,char requestType){
        this.floor = floor;
        this.requestType=requestType;
        date=new Date();
    }

    public int getFloor() {
        return floor;
    }

    public long requestTime(){
        return date.getTime();
    }

    public char getRequestType() {
        return requestType;
    }
}
