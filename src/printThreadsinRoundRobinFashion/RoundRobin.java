package printThreadsinRoundRobinFashion;

public class RoundRobin {
    public static void main(String[] args) {
        Counter counter=new Counter();
        counter.setMaxNoTobePrinted(10000);
        int totalThread=4;
        Object lock=new Object();
        Thread t1=new Thread(new PrintNumber(counter,totalThread,lock));
        Thread t2=new Thread(new PrintNumber(counter,totalThread,lock));
        Thread t3=new Thread(new PrintNumber(counter,totalThread,lock));
        Thread t4=new Thread(new PrintNumber(counter,totalThread,lock));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}