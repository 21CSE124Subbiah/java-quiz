import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MostCommonWordFinder 
{

    public static void main(String[] args) 
    {
        // Get user input for the directory path
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter directory name: ");
        String directoryPath = scanner.nextLine();

        try 
        {
            // Find the most common word in the given directory
            findMostCommonWord(directoryPath);

        } 
        catch (IOException e) 
        {
            System.out.println("Error reading files: " + e.getMessage());
        }
        scanner.close();
    }

    private static void findMostCommonWord(String directoryPath) throws IOException 
    {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) 
            {
                if (file.isFile() && file.getName().endsWith(".txt"))
                {
                    processTextFile(file, wordFrequencyMap);
                }
            }

            findAndPrintMostCommonWords(wordFrequencyMap);

        } else {
            System.out.println("No files found in the directory.");
        }
    }

    private static void processTextFile(File file, Map<String, Integer> wordFrequencyMap) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");

                // Update word frequencies in the map
                for (String word : words) {
                    // Ignore case sensitivity
                    word = word.toLowerCase();

                    // Update word frequency
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }
    }

    private static void findAndPrintMostCommonWords(Map<String, Integer> wordFrequencyMap) {
        int maxFrequency = 0;

        // Find the maximum frequency
        for (int frequency : wordFrequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        // Print words with the maximum frequency
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                System.out.println("Word: " + entry.getKey() + ", Frequency: " + entry.getValue());
            }
        }
    }
}
