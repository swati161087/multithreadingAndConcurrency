package printThreadsinRoundRobinFashion;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger val=new AtomicInteger(0);
    private AtomicInteger track=new AtomicInteger(0);
    private int MaxNoTobePrinted;

    public int getMaxNoTobePrinted() {
        return MaxNoTobePrinted;
    }

    public void setMaxNoTobePrinted(int maxNoTobePrinted) {
        MaxNoTobePrinted = maxNoTobePrinted;
    }

    public  void  printVal(){
        System.out.println(this.getVal());
    }
    public int getVal() {
        return val.get();
    }
    public int getTrack() {
        return track.get();
    }
    public void setVal(int val) {
        this.val.set(val);
    }
    public void setTrack(int val) {
        this.track.set(val);
    }
    public void incrementVal(){
        this.val.set(this.val.get()+1);
    }
    public void incrementTrack(){
        this.track.set(this.track.get()+1);
    }
}