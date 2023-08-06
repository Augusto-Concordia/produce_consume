import java.util.List;
import java.util.Random;

public class Producer {
    private float probability;

    private Random random;

    public Producer(float probability) {
        this.probability = probability;
        this.random = new Random();
    }

    public void Produce(List<Integer> buffer) {
        if (probability >= random.nextFloat())
            buffer.add(random.nextInt());
    }
}
