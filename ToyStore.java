
import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {

    private PriorityQueue<Toy> toys = new PriorityQueue<>();
    private int[] weights;
    private int totalWeight;

    public ToyStore(String[] ids, String[] names, int[] frequencies) {
        if (ids.length != names.length || ids.length != frequencies.length) {
            throw new IllegalArgumentException("Входящие массивы должны иметь одинаковую длинну");
        }
        weights = new int[frequencies.length];
        for (int i = 0; i < frequencies.length; i++) {
            toys.add(new Toy(ids[i], names[i], frequencies[i]));
            weights[i] = frequencies[i];
            totalWeight += frequencies[i];
        }
    }

    public Toy getRandomToy() {
        int randomWeight = new Random().nextInt(totalWeight);
        int weightSum = 0;
        for (int i = 0; i < toys.size(); i++) {
            weightSum += weights[i];
            if (randomWeight < weightSum) {
                return toys.toArray(new Toy[0])[i];
            }
        }
        return null;
    }

}
