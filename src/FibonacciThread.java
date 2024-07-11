import java.io.FileWriter;
import java.io.IOException;

public class FibonacciThread implements Runnable {

    @Override
    public void run() {
        int fib15 = fibonacci(15);

        try (FileWriter writer = new FileWriter("out.txt", true)) {
            synchronized (Main.class) {
                writer.write("15th Fibonacci number: " + fib15 + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
