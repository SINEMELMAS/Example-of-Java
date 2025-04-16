package level1;

import java.util.Scanner;

/**
 * A simple console-based calculator application.
 * This program performs basic arithmetic operations: addition, subtraction,
 * multiplication, and division.
 */
public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Simple Calculator!");
        System.out.println("Please follow the instructions to perform a calculation.");

        // Input: First number
        System.out.print("Enter the first number: ");
        double firstNumber = scanner.nextDouble();

        // Input: Operator
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Input: Second number
        System.out.print("Enter the second number: ");
        double secondNumber = scanner.nextDouble();

        // Perform the calculation and display the result
        double result;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = firstNumber - secondNumber;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = firstNumber * secondNumber;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
        }

        // Closing message
        System.out.println("Thank you for using the Simple Calculator. Goodbye!");
        scanner.close();
    }
}

