package level2;

import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the text
        System.out.println("Enter the text:");
        String text = sc.nextLine();

        // Ask the user to enter the word they want to search for
        System.out.println("Enter the word to search for:");
        String word = sc.nextLine();

        // Count the occurrences of the word in the text
        int count = countWordOccurrences(text, word);

        // Display the result
        System.out.println("The word '" + word + "' appears " + count + " times in the text.");
    }

    // Method to count how many times the word appears in the text
    public static int countWordOccurrences(String text, String word) {
        // Split the text into words based on spaces
        String[] words = text.split("\\s+");
        
        int count = 0;
        
        // Iterate over the words and check for matches
        for (String w : words) {
            // Check for case-insensitive match
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        
        return count;
    }
}

