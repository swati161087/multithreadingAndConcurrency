package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Left implements Runnable{
    String msg;
    Left(String msg){
        this.msg=msg;
    }
    @Override
    public void run() {
        System.out.println("print left" +msg);
    }
}

class Right implements Runnable{
    String msg;
    Right(String msg){
        this.msg=msg;
    }
    @Override
    public void run() {
        System.out.println("print right" +msg);
    }
}

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<100;i++){
            Thread t1=new Thread(new Left("thread"));
            Thread t2=new Thread(new Right("thread"));
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        }

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(new Left("executor"));
        executorService.submit(new Right("executor"));
    }
}
