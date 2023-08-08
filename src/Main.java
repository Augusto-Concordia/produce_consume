import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final int COUNT = 10;


        System.out.println("Enter a value for q");
        Scanner in = new Scanner(System.in);
        float q = -1, p = 0; //Initialization of q and p

        //The handling of q
        try{
            q = in.nextFloat();
            p = 1 - q;
        }catch(Exception e){
            System.out.println("q is NAN");
        }

        Semaphore mutex = new Semaphore(1);
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(COUNT);
        ArrayList<Integer> buffer = new ArrayList<>(COUNT);

        if (q >=0 && q <=1){
            Producer producer = new Producer(q);
            Consumer consumer = new Consumer(p);
            int x =0;
            for(int i =0; i <100; i++){
                // Producer action
                empty.Wait();
                mutex.Wait();
                producer.Produce(buffer,COUNT);
                mutex.Signal();
                full.Signal();

                // Consumer action
                full.Wait();
                mutex.Wait();
                consumer.Consume(buffer);
                mutex.Signal();
                empty.Signal();
                x = i;
            }
            System.out.println("Total production in for " + x + " runs " +
                    "is " + producer.getTotalProduction() + " and total consumption is " +
                    + consumer.getTotalConsumption());
        }
        else{
            System.out.println("Error, q has to be less than 1 and greater than 0");
        }




        /*Output on the console the following:
        Generation of an items
        Consumption of an Item
        isEmpty() or isFull
        State of the processes whether they are in the state of busy waiting
         */
    }



}