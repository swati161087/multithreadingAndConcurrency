package runnableThread;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> allThread=new ArrayList<>();
        for(int i=0;i<10;i++){
            NumberPrint numberPrint=new NumberPrint(i);
            Thread t=new Thread(numberPrint);
            allThread.add(t);
            t.start();
            t.join();
        }
        for(int i=0;i<10;++i){
            allThread.get(i).join();  // it will wait for thread to end then it will start main method.
        }
        System.out.println("hello world");
    }
}
