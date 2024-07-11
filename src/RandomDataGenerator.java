import java.io.*;
import java.util.*;

public class RandomDataGenerator {

    public static void main(String[] args) {
        generateTestFile("test.txt", 100);
    }

    public static void generateTestFile(String filename, int phoneCount) {
        Random random = new Random();
        List<String> phoneNumbers = new ArrayList<>();

        for (int i = 0; i < phoneCount; i++) {
            String phoneNumber = generateRandomPhoneNumber(random);
            phoneNumbers.add(phoneNumber);
        }

        List<String> randomTexts = Arrays.asList(
                "random text 1", "example text", "some more random text",
                "another example", "text", "sample", "more text", "even more text"
        );

        try (FileWriter writer = new FileWriter(filename)) {
            for (String phoneNumber : phoneNumbers) {
                writer.write(phoneNumber + "\n");

                String randomText = randomTexts.get(random.nextInt(randomTexts.size()));
                writer.write(randomText + "\n");
            }
            System.out.println("Файл " + filename + " успішно створено та заповнено випадковими даними.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomPhoneNumber(Random random) {
        StringBuilder phoneNumber = new StringBuilder("+380");
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
}
