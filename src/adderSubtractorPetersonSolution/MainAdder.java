package adderSubtractorPetersonSolution;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainAdder{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter counter=new Counter();
        Flags flags=new Flags();
        Adder adder=new Adder(counter,flags);
        Subtractor subtractor=new Subtractor(counter,flags);
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
