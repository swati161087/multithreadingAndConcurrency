package adderSubtractorSynchronisedSolution;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainAdder{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter=new Counter();
        Adder adder=new Adder(counter);
        Subtractor subtractor=new Subtractor(counter);
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
        finally {
            executorService.shutdown();
        }

        System.out.println(counter.getValue());

    }
}
