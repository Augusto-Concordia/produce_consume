import java.util.List;
import java.util.Random;

public class Producer {
    private final Random random; //Produces random integers that is less than 0.0 and greater than 1.0
    private final float probability;

    private int totalProduction = 0;

    public Producer(float probability) {
        this.probability = probability;
        this.random = new Random();
    }

    public void Produce(List<Integer> buffer, int maxBufferSize) {
        if (buffer.size() < maxBufferSize && probability >= random.nextFloat()) {
            int item = random.nextInt(100); // Producing a random integer between 0 and 99
            buffer.add(item);
            System.out.println("An item was PRODUCED and is " + item);
            totalProduction++;

            return;
        }

        System.out.println("Producer WAITING");
    }

    public int getTotalProduction(){return totalProduction;}

}
