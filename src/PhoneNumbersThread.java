import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneNumbersThread implements Runnable {

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("+380")) {
                    try (FileWriter writer = new FileWriter("out.txt", true)) {
                        synchronized (Main.class) {
                            writer.write("Phone number: " + line + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
