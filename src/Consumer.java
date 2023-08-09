import java.util.List;
import java.util.Random;

public class Consumer {
    private final Random random;
    private final float probability;

    private int totalConsumption = 0;


    public Consumer(float probability) {
        this.probability = probability;
        this.random = new Random();
    }

    public void Consume(List<Integer> buffer) {
        if (!buffer.isEmpty() && probability >= random.nextFloat()) {
            int item = buffer.remove(0);
            System.out.println("An item was CONSUMED and is " + item);
            totalConsumption++;

            return;
        }

        System.out.println("Consumer WAITING");
    }
    public int getTotalConsumption(){return totalConsumption;}
}
