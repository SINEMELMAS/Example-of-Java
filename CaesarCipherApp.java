package level3;

import java.util.Scanner;

public class CaesarCipherApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Caesar Cipher Application!");
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a message");
        System.out.println("2. Decrypt a message");
        int choice = sc.nextInt();
        sc.nextLine(); // Clear the buffer

        if (choice == 1) {
            // Encrypt a message
            System.out.println("Enter the message to encrypt:");
            String message = sc.nextLine();
            System.out.println("Enter the shift key (1-25):");
            int key = sc.nextInt();
            String encryptedMessage = encrypt(message, key);
            System.out.println("Encrypted message: " + encryptedMessage);
        } else if (choice == 2) {
            // Decrypt a message
            System.out.println("Enter the message to decrypt:");
            String encryptedMessage = sc.nextLine();
            System.out.println("Enter the shift key (1-25):");
            int key = sc.nextInt();
            String decryptedMessage = decrypt(encryptedMessage, key);
            System.out.println("Decrypted message: " + decryptedMessage);
        } else {
            System.out.println("Invalid choice. Please restart the program.");
        }
    }

    // Method to encrypt the message using Caesar Cipher
    public static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();
        key = key % 26; // Ensure key is within the alphabet range

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + key) % 26 + base));
            } else {
                encrypted.append(c); // Non-letter characters are not encrypted
            }
        }
        return encrypted.toString();
    }

    // Method to decrypt the message using Caesar Cipher
    public static String decrypt(String encryptedMessage, int key) {
        StringBuilder decrypted = new StringBuilder();
        key = key % 26; // Ensure key is within the alphabet range

        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) ((c - base - key + 26) % 26 + base));
            } else {
                decrypted.append(c); // Non-letter characters are not decrypted
            }
        }
        return decrypted.toString();
    }
}

