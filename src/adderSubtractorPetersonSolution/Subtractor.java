package adderSubtractorPetersonSolution;

public class Subtractor implements Runnable{
    Counter counter;
    Flags flags;
    Subtractor(Counter counter,Flags flags){
        this.counter=counter;
        this.flags=flags;
    }
    @Override
    public void run() {
        this.flags.flag[1]=true;
        this.flags.turn=0;
        while (this.flags.flag[0] && this.flags.turn==0){
            System.out.println("subtractor is waiting");
        }
        for(int i=0;i<10000000;i++){
            this.counter.value-=1;
        }
        this.flags.flag[1]=false;
    }
}