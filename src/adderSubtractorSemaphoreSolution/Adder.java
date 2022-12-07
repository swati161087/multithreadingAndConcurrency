package adderSubtractorSemaphoreSolution;

import java.util.concurrent.Semaphore;

public class Adder implements Runnable{
    Counter counter;
    Semaphore semaphore;
    Adder(Counter counter, Semaphore semaphore){
        this.counter=counter;
        this.semaphore=semaphore;
    }
    @Override
    public void run() {
        while (!semaphore.tryAcquire()){
            System.out.println("adder waiting for the lock");

        }
        for(int i=0;i<10000000;i++){
            this.counter.value+=1;
        }
        semaphore.release();
    }
}