import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new FibonacciThread());
        Thread thread2 = new Thread(new SumFromFileThread());
        Thread thread3 = new Thread(new PhoneNumbersThread());

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();

            displayOutputFile("out.txt");

            System.out.println("Всі операции завершені.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void displayOutputFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("Вміст файлу " + filename + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
