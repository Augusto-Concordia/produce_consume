import java.util.List;
import java.util.Random;

public class Producer {
    private float probability;
    private int totalProduction;
    private Random random; //Produces random integers that is less than 0.0 and greater than 1.0

    public Producer(float probability) {
        this.probability = probability;
        this.random = new Random();
    }

    public void Produce(List<Integer> buffer, int maxBufferSize) {
        if (buffer.size() < maxBufferSize && probability >= random.nextFloat()) {
            int item = random.nextInt(100); // Producing a random integer between 0 and 99
            buffer.add(item);
            System.out.println("The item produced is " + item + " and buffer size is " + buffer.size());
            totalProduction++;
        }
    }

    public int getTotalProduction(){return totalProduction;}

}
