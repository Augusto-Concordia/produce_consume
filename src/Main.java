import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int COUNT = 10;


        System.out.print("Enter a value for q: ");
        Scanner in = new Scanner(System.in);
        float q = -1, p = 0; //Initialization of q and p

        //The handling of q
        try {
            q = in.nextFloat();
            p = 1 - q;
        } catch (Exception e) {
            System.out.println("q is NAN");
        }

        Semaphore mutex = new Semaphore(1);
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(COUNT);
        ArrayList<Integer> buffer = new ArrayList<>(COUNT);

        if (q < 0 || q > 1) {
            System.out.println("Error, q has to be less than 1 and greater than 0");
            return;
        }

        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(p);

        System.out.println();

        int x = 0;

        for (int i = 0; i < 10; i++) {
            // Producer action
            empty.Wait();
            System.out.println("Semaphore EMPTY is " + empty.getValue());

            mutex.Wait();
            System.out.println("Semaphore MUTEX is " + mutex.getValue());

            producer.Produce(buffer, COUNT);

            mutex.Signal();
            System.out.println("Semaphore MUTEX is " + mutex.getValue());

            full.Signal();
            System.out.println("Semaphore FULL is " + full.getValue());

            // Consumer action
            full.Wait();
            System.out.println("Semaphore FULL is " + full.getValue());

            mutex.Wait();
            System.out.println("Semaphore MUTEX is " + mutex.getValue());

            consumer.Consume(buffer);

            mutex.Signal();
            System.out.println("Semaphore MUTEX is " + mutex.getValue());

            empty.Signal();
            System.out.println("Semaphore EMPTY is " + empty.getValue());

            x = i;

            if (buffer.size() == COUNT) {
                System.out.println("Buffer is full");
            } else if (buffer.isEmpty()) {
                System.out.println("Buffer is empty");
            } else {
                System.out.println("Buffer size is " + buffer.size());
            }

            System.out.println();
        }

        System.out.println("\nTotal production for " + x + " runs " +
                "is " + producer.getTotalProduction() + " and total consumption is " +
                consumer.getTotalConsumption());
    }

}