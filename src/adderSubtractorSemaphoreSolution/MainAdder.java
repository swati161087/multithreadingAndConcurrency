package adderSubtractorSemaphoreSolution;

import java.util.concurrent.*;

public class MainAdder{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter=new Counter();
        Semaphore semaphore=new Semaphore(1);
        Adder adder=new Adder(counter,semaphore);
        Subtractor subtractor=new Subtractor(counter,semaphore);
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        Future adderRes=executorService.submit(adder);
        Future subtractorRes=executorService.submit(subtractor);
        try{
            adderRes.get();
            subtractorRes.get();
        }
    catch (Exception e){
            System.out.println(e.getMessage());
    }

        System.out.println(counter.value);

    }
}
