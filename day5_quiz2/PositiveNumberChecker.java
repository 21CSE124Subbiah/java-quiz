import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PositiveNumberChecker {

    public static void main(String[] args) {
        try 
        {
            // Get user input for the file path
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();

            // Read numbers from the file
            checkNumbersInFile(filePath);
            scanner.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Error reading the file: " + e.getMessage());
        } 
        catch (PositiveNumberException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void checkNumbersInFile(String filePath) throws IOException, PositiveNumberException {
        // Open the file for reading
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();

            if (line != null) {
                // Display the content of the file
                System.out.println("Content of " + filePath + ": " + line);

                // Check for positive numbers
                String[] numbers = line.split(" ");
                for (String numStr : numbers) {
                    int num = Integer.parseInt(numStr);
                    if (num > 0) {
                        throw new PositiveNumberException("Positive number found: " + num);
                    }
                }

                System.out.println("No positive numbers found.");
            } else {
                System.out.println("File is empty.");
            }
        }
    }

    // Custom exception for positive numbers
    static class PositiveNumberException extends Exception {
        public PositiveNumberException(String message) {
            super(message);
        }
    }
}
