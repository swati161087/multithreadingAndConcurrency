package mergeSortUsingCallableThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {
    List<Integer> listTobeSorted;
    MergeSort( List<Integer> listTobeSorted){
        this.listTobeSorted=listTobeSorted;
    }
    public List<Integer> sortArrayWithoutThread(List<Integer> a){
        if(a.size()==0)return new ArrayList<>();
        if(a.size()==1)return a;
        int mid=a.size()/2;
        List<Integer>leftArray=new ArrayList<>();
        List<Integer> rightArray=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            if(i<mid){
                leftArray.add(a.get(i));
            }
            else {
                rightArray.add(a.get(i));
            }
        }
        List<Integer>leftArraySorted=sortArrayWithoutThread(leftArray);
        List<Integer>rightArraySorted=sortArrayWithoutThread(rightArray);
        return merge(leftArraySorted,rightArraySorted);

    }
    public List<Integer> merge(List<Integer> a, List<Integer> b){
        int p1=0;
        int p2=0;
        int n=a.size();
        int m=b.size();
        List<Integer> mergedArrayList=new ArrayList<>();
        if(n==0 && m==0){
           return new ArrayList<>();
        }

        while (p1<=n || p2<=m){
            if(p1==n && p2==m){
                return mergedArrayList;
            }
            else if(p1==n){
                while (p2!=m){
                    mergedArrayList.add(b.get(p2));
                    p2++;
                }
                return mergedArrayList;
            }
            else if(p2==m){
                while (p1!=n){
                    mergedArrayList.add(a.get(p1));
                    p1++;
                }
                return mergedArrayList;
            }
            if(a.get(p1)<b.get(p2)){
                mergedArrayList.add(a.get(p1));
                p1++;
            }
            else{
                mergedArrayList.add(b.get(p2));
                p2++;
            }
        }
        return mergedArrayList;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(listTobeSorted.size()==0)return new ArrayList<>();
        if(this.listTobeSorted.size()==1)return this.listTobeSorted;
        int mid=this.listTobeSorted.size()/2;
        List<Integer>leftArray=new ArrayList<>();
        List<Integer> rightArray=new ArrayList<>();
        for(int i=0;i<this.listTobeSorted.size();i++){
            if(i<mid){
                leftArray.add(this.listTobeSorted.get(i));
            }
            else {
                rightArray.add(this.listTobeSorted.get(i));
            }
        }
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<List<Integer>> futureLeft=executorService.submit(new MergeSort(leftArray));
        Future<List<Integer>> futureRight=executorService.submit(new MergeSort((rightArray)));

        List<Integer>leftArraySorted=futureLeft.get();
        List<Integer>rightArraySorted=futureRight.get();
        return merge(leftArraySorted,rightArraySorted);
    }
}
