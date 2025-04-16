package level2;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Display contact details
    public void displayContact() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("------------------------------");
    }
}

public class PhoneBookApp {

    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Main menu loop
        while (true) {
            System.out.println("\n--- Phone Book Application ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Remove Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                // Add Contact
                System.out.print("Enter contact name: ");
                String name = sc.nextLine();
                System.out.print("Enter contact phone number: ");
                String phoneNumber = sc.nextLine();
                addContact(name, phoneNumber);
            } else if (choice == 2) {
                // Display all contacts
                displayContacts();
            } else if (choice == 3) {
                // Search for a contact
                System.out.print("Enter contact name to search: ");
                String searchName = sc.nextLine();
                searchContact(searchName);
            } else if (choice == 4) {
                // Remove Contact
                System.out.print("Enter contact name to remove: ");
                String nameToRemove = sc.nextLine();
                removeContact(nameToRemove);
            } else if (choice == 5) {
                // Exit
                System.out.println("Exiting the application.");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to add a new contact
    public static void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);
        System.out.println("Contact added successfully.");
    }

    // Method to display all contacts
    public static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("\n--- Your Contacts ---");
            for (Contact contact : contacts) {
                contact.displayContact();
            }
        }
    }

    // Method to search for a contact by name
    public static void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.displayContact();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Method to remove a contact by name
    public static void removeContact(String name) {
        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact removed successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}

