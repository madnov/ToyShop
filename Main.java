import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    private static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        put("1 конструктор");
        put("2 робот");
        put("3 кукла");

        try {
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < 10; i++) {
                String result = get();
                writer.write(result + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void put(String data) {
        queue.add(data);
    }

    static String get() {
        int weight = random.nextInt(10);
        if (weight < 2) {
            return "1 конструктор";
        } else if (weight < 4) {
            return "2 робот";
        } else {
            String result = queue.poll();
            queue.add(result);
            return result;
        }
    }
}
