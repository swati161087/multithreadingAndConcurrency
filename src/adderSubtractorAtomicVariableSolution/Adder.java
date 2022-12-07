package adderSubtractorAtomicVariableSolution;

public class Adder implements Runnable{
    Counter counter;
    Flags flags;
    Adder(Counter counter, Flags flags){
        this.counter=counter;
        this.flags=flags;
    }
    @Override
    public void run() {
        this.flags.flag.get(0).set(true);
        this.flags.turn.set(1);
        while (this.flags.flag.get(1).get() && this.flags.turn.get()==1){
            System.out.println("adder is waiting");
        }
        for(int i=0;i<10000000;i++){
            this.counter.value+=1;
        }
        this.flags.flag.get(0).set(false);
    }
}