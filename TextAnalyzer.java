package level3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for the file path
        System.out.println("Enter the path to the text file:");
        String filePath = sc.nextLine();

        // Read the file and analyze the text
        try {
            String text = readFile(filePath);
            Map<String, Integer> wordFrequency = analyzeText(text);

            // Display the word frequencies sorted by frequency
            System.out.println("\nWord Frequency Analysis:");
            wordFrequency.entrySet().stream()
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file path and try again.");
        }
    }

    // Method to read the file and return the content as a string
    public static String readFile(String filePath) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filePath));
        StringBuilder text = new StringBuilder();

        // Read file line by line
        while (fileScanner.hasNextLine()) {
            text.append(fileScanner.nextLine()).append(" ");
        }

        return text.toString();
    }

    // Method to analyze the text and count word frequencies
    public static Map<String, Integer> analyzeText(String text) {
        // Convert text to lowercase and split it into words
        String[] words = text.toLowerCase().split("\\W+");

        // Use a HashMap to store word frequencies
        Map<String, Integer> wordFrequency = new HashMap<>();

        // Count the frequency of each word
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequency;
    }
}

