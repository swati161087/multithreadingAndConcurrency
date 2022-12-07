package adderSubtractorSynchronisedSolution;

public class Counter {
     private int value=0;

     public synchronized int getValue() {
          return value;
     }
     public synchronized void add(int i){
          this.value=this.value+i;
          System.out.println("added");
     }
     public synchronized void sub(int i){
          this.value=this.value-i;
          System.out.println("subtract");
     }
}
