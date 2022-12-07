package synchronised;


public class RunnableThread3 implements Runnable{
    SynchronisedBlock synchronisedBlock;
    RunnableThread3(SynchronisedBlock synchronisedBlock){
        this.synchronisedBlock=synchronisedBlock;
    }
    @Override
    public void run() {
        synchronisedBlock.m3();
    }
}