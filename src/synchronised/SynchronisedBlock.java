package synchronised;

public class SynchronisedBlock {
    public synchronized void m1(){
        System.out.println("print m1");
    }
    public synchronized void m2(){
        System.out.println("print m2");
    }
    public void m3(){
        System.out.println("print m3");
    }
}
