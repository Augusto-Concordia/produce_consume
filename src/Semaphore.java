public class Semaphore {
    private int s;

    public int getValue() {
        return s;
    }

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
