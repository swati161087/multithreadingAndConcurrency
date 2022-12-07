package runnableThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass2 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            NumberPrint numberPrint=new NumberPrint(i);
            executorService.submit(numberPrint);
        }
    }
}
