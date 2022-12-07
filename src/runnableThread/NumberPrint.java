package runnableThread;

public class NumberPrint implements Runnable{
    int i;
    NumberPrint(int i){
        this.i=i;
    }
    @Override
    public void run() {
        if(i==50){
            System.out.println("wait");
        }
        System.out.println("the no is " + i);
    }
}
