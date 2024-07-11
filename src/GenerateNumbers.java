import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter("numbers.txt")) {
            for (int i = 0; i < 100; i++) {
                int number = 1 + random.nextInt(99999);
                writer.write(number + "\n");
            }
            System.out.println("Файл numbers.txt успішно створено та заповнено випадковими числами.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
