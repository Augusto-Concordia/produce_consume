import java.util.List;
import java.util.Random;

public class Consumer {
    private float probability;

    private int totalConsumption = 0;

    private Random random;

    public Consumer(float probability) {
        this.probability = probability;
        this.random = new Random();
    }

    public void Consume(List<Integer> buffer) {
        if(!buffer.isEmpty()){
            if (probability >= random.nextFloat()){
                int item = buffer.remove(0);
                System.out.println("The item CONSUMED is " + item + " and buffer size is " + buffer.size());
                totalConsumption++;
            }
        }
    }
    public int getTotalConsumption(){return totalConsumption;}
}
