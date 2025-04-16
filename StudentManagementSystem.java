package level1;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int age;
    String studentNumber;
    double grade;

    // Constructor for student
    public Student(String name, int age, String studentNumber, double grade) {
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student Number: " + studentNumber);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------");
    }
}

public class StudentManagementSystem {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Main loop to manage students
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                System.out.print("Enter student age: ");
                int age = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Enter student number: ");
                String studentNumber = sc.nextLine();
                System.out.print("Enter student grade: ");
                double grade = sc.nextDouble();
                
                Student student = new Student(name, age, studentNumber, grade);
                students.add(student);
            } else if (choice == 2) {
                for (Student student : students) {
                    student.displayDetails();
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

