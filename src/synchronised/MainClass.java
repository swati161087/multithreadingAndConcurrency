package synchronised;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static void main(String[] args) {
        SynchronisedBlock synchronisedBlock=new SynchronisedBlock();
        ExecutorService executorService= Executors.newFixedThreadPool(15);
        for(int i=0;i<100;i++){
            executorService.submit(new RunningThread1(synchronisedBlock));
            executorService.submit(new RunnableThread2(synchronisedBlock));
            executorService.submit(new RunnableThread3(synchronisedBlock));
        }
    }
}
