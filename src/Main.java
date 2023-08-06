import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int COUNT = 10;

        Semaphore mutex = new Semaphore(1);
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(COUNT);

        ArrayList<Integer> buffer = new ArrayList<>(COUNT);

        Producer producer = new Producer(0.5f);
        Consumer consumer = new Consumer(0.5f);
    }
}