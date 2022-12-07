package mergeSortUsingCallableThreads;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergSortMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> a=List.of(1,4,9);
        List<Integer> b=List.of(67,2,6,1,4,9,10,23,45);
        MergeSort mergeSort=new MergeSort(b);
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future resfuture=executorService.submit(mergeSort);

        List<Integer> res= (List<Integer>) resfuture.get();
        executorService.shutdown();
        System.out.println(res);

    }
}
