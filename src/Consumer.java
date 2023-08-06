import java.util.List;
import java.util.Random;

public class Consumer {
    private float probability;

    private Random random;

    public Consumer(float probability) {
        this.probability = probability;
        this.random = new Random();
    }

    public void Consume(List<Integer> buffer) {
        if (probability >= random.nextFloat())
            buffer.remove(0);
    }
}
