package level2;

import java.util.ArrayList;
import java.util.Scanner;

class Note {
    private String title;
    private String content;

    // Constructor
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Display note details
    public void displayNote() {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("-----------------------------");
    }

    // Update content of the note
    public void updateContent(String newContent) {
        this.content = newContent;
    }
}

public class NotebookApp {

    private static ArrayList<Note> notes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Main menu loop
        while (true) {
            System.out.println("\n--- Notebook Application ---");
            System.out.println("1. Add Note");
            System.out.println("2. Display Notes");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                // Add Note
                System.out.print("Enter note title: ");
                String title = sc.nextLine();
                System.out.print("Enter note content: ");
                String content = sc.nextLine();
                addNote(title, content);
            } else if (choice == 2) {
                // Display all notes
                displayNotes();
            } else if (choice == 3) {
                // Update Note
                System.out.print("Enter note number to update: ");
                int noteNumber = sc.nextInt();
                sc.nextLine(); // consume newline
                if (noteNumber <= notes.size() && noteNumber > 0) {
                    System.out.print("Enter new content for note: ");
                    String newContent = sc.nextLine();
                    updateNoteContent(noteNumber - 1, newContent); // 0-based index
                } else {
                    System.out.println("Invalid note number.");
                }
            } else if (choice == 4) {
                // Delete Note
                System.out.print("Enter note number to delete: ");
                int noteNumber = sc.nextInt();
                if (noteNumber <= notes.size() && noteNumber > 0) {
                    deleteNote(noteNumber - 1); // 0-based index
                } else {
                    System.out.println("Invalid note number.");
                }
            } else if (choice == 5) {
                // Exit
                System.out.println("Exiting the application.");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to add a note
    public static void addNote(String title, String content) {
        Note newNote = new Note(title, content);
        notes.add(newNote);
        System.out.println("Note added successfully.");
    }

    // Method to display all notes
    public static void displayNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            System.out.println("\n--- Your Notes ---");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". ");
                notes.get(i).displayNote();
            }
        }
    }

    // Method to update content of a note
    public static void updateNoteContent(int index, String newContent) {
        notes.get(index).updateContent(newContent);
        System.out.println("Note content updated successfully.");
    }

    // Method to delete a note
    public static void deleteNote(int index) {
        notes.remove(index);
        System.out.println("Note deleted successfully.");
    }
}

