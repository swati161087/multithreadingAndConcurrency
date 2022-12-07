package adderSubtractorAtomicVariableSolution;

public class Subtractor implements Runnable{
    Counter counter;
    Flags flags;
    Subtractor(Counter counter, Flags flags){
        this.counter=counter;
        this.flags=flags;
    }
    @Override
    public void run() {
        this.flags.flag.get(1).set(true);
        this.flags.turn.set(0);
        while (this.flags.flag.get(0).get() && this.flags.turn.get()==0){
            System.out.println("adder is waiting");
        }
        for(int i=0;i<10000000;i++){
            this.counter.value-=1;
        }
        this.flags.flag.get(1).set(false);
    }
}