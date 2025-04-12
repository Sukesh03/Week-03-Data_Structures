import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInputToFile {
    public static void main(String[] args) {
        String filePath = "user_input.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filePath, true)) {

            String input;
            System.out.println("Enter text (type 'exit' to stop):");

            while (true) {
                input = reader.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(input + System.lineSeparator());
            }

            System.out.println("Input has been saved to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
