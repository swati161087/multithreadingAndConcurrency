package synchronised;

public class RunnableThread2 implements Runnable{
    SynchronisedBlock synchronisedBlock;
    RunnableThread2(SynchronisedBlock synchronisedBlock){
        this.synchronisedBlock=synchronisedBlock;
    }
    @Override
    public void run() {
        synchronisedBlock.m2();
    }
}