package synchronised;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunningThread1 implements Runnable{
    SynchronisedBlock synchronisedBlock;
    RunningThread1(SynchronisedBlock synchronisedBlock){
        this.synchronisedBlock=synchronisedBlock;
    }
    @Override
    public void run() {
       synchronisedBlock.m1();
    }
}
