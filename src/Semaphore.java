public class Semaphore {
    private int s;
    private final Object lock = new Object();

    public Semaphore(int initial) {
        s = initial;
    }

    public void Wait() {
        s--;
    }

    public void Signal() {
        s++;
    }
}
