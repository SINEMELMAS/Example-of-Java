package level3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IndexingApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for the file path
        System.out.println("Enter the path to the text file:");
        String filePath = sc.nextLine();

        // Read the file and build the index
        try {
            String text = readFile(filePath);
            Map<String, StringBuilder> wordIndex = buildIndex(text);

            // Allow the user to search for a word in the index
            System.out.println("\nEnter a word to search for in the index:");
            String searchWord = sc.nextLine().toLowerCase();

            // Display the search result
            if (wordIndex.containsKey(searchWord)) {
                System.out.println("The word '" + searchWord + "' appears in the following lines:");
                System.out.println(wordIndex.get(searchWord).toString());
            } else {
                System.out.println("The word '" + searchWord + "' was not found in the text.");
            }

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
            text.append(fileScanner.nextLine()).append("\n");
        }

        return text.toString();
    }

    // Method to build the word index
    public static Map<String, StringBuilder> buildIndex(String text) {
        Map<String, StringBuilder> wordIndex = new HashMap<>();
        String[] lines = text.split("\n");

        // Process each line of text
        for (int lineNumber = 0; lineNumber < lines.length; lineNumber++) {
            String[] words = lines[lineNumber].toLowerCase().split("\\W+");  // Split words by non-word characters

            // Process each word in the line
            for (String word : words) {
                if (!word.isEmpty()) {
                    // Add the line number to the word index
                    wordIndex.putIfAbsent(word, new StringBuilder());
                    wordIndex.get(word).append(lineNumber + 1).append(", ");
                }
            }
        }

        return wordIndex;
    }
}

