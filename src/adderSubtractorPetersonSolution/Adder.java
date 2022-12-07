package adderSubtractorPetersonSolution;

public class Adder implements Runnable{
    Counter counter;
    Flags flags;
    Adder(Counter counter,Flags flags){
        this.counter=counter;
        this.flags=flags;
    }
    @Override
    public void run() {
        this.flags.flag[0]=true;
        this.flags.turn=1;
        while (this.flags.flag[1] && this.flags.turn==1){
            System.out.println("adder is waiting");
        }
        for(int i=0;i<10000000;i++){
            this.counter.value+=1;
        }
        this.flags.flag[0]=false;
    }
}