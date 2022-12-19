package printThreadsinRoundRobinFashion;

import java.util.concurrent.Semaphore;

public class PrintNumber implements Runnable{
    Counter counter;
    int totalThreads;
    Object lock;
    PrintNumber(Counter counter,int totalThreads,Object lock){
        this.counter=counter;
        this.totalThreads=totalThreads;
        this.lock=lock;
    }


    @Override
    public void run() {
        synchronized (lock) {
            while (counter.getTrack() != counter.getMaxNoTobePrinted()*this.totalThreads ) {

                String currentThread = Thread.currentThread().getName();
                String chanceThread = "Thread-" + (counter.getTrack() % totalThreads);
                if (currentThread.equals(chanceThread)) {
                    if (counter.getTrack() % totalThreads == 0) {
                        counter.incrementVal();
                    }
                    System.out.println(chanceThread + " :-> " + counter.getVal());

                    counter.incrementTrack();

                    lock.notifyAll();

                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}