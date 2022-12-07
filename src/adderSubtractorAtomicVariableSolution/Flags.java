package adderSubtractorAtomicVariableSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Flags {
   List<AtomicBoolean> flag=new ArrayList<>();
     AtomicInteger turn=new AtomicInteger(2);
   Flags(){
       flag.add(new AtomicBoolean(false));
       flag.add(new AtomicBoolean(false));

   }

}
