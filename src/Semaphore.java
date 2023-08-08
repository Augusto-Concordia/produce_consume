public class Semaphore {
    private int s;


    public Semaphore(int initial) {
        s = initial;
    }

    public void Wait() {
        s--;
    }

    public void Signal() {
        s++;
    }

    /*
    in the notes the definition of wait:
    wait{
        while (s<=0)
           ;
        s--;
    }
    why?, do we need to implement it this way
     */

    //Do we need to ensure thread safety? by using a lock object?

    //Usage of probability (No strict implementation is that okay?)
}
