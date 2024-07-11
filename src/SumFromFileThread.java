import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SumFromFileThread implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 10) {
                int number = Integer.parseInt(line.trim());
                sum += number;
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("out.txt", true)) {
            synchronized (Main.class) {
                writer.write("Sum of first 10 numbers from numbers.txt: " + sum + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
