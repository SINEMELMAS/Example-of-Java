package level1;

import java.util.Scanner;

/**
 * A simple stopwatch application.
 * This program allows the user to start, stop, and reset a timer using the console.
 */
public class SimpleStopwatch {

    private static volatile boolean running = false;  // Added volatile for visibility
    private static volatile int elapsedTime = 0;     // in seconds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Thread timerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                long startTime = System.currentTimeMillis();
                
                if (running) {
                    try {
                        Thread.sleep(1000 - (System.currentTimeMillis() - startTime));
                        elapsedTime++;
                        System.out.printf("\rCurrent time: %02d:%02d", elapsedTime / 60, elapsedTime % 60);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else {
                    try {
                        Thread.sleep(100); // Small sleep when not running to reduce CPU usage
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });

        timerThread.setDaemon(true);
        timerThread.start();

        System.out.println("Simple Stopwatch");
        System.out.println("Commands: start, stop, reset, exit");

        while (true) {
            System.out.print("\nEnter command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "start":
                    if (!running) {
                        running = true;
                        System.out.println("Stopwatch started. Current time: 00:00");
                    } else {
                        System.out.println("Stopwatch is already running.");
                    }
                    break;
                case "stop":
                    if (running) {
                        running = false;
                        System.out.printf("\nStopwatch stopped at %02d:%02d.%n", elapsedTime / 60, elapsedTime % 60);
                    } else {
                        System.out.println("Stopwatch is not running.");
                    }
                    break;
                case "reset":
                    running = false;
                    System.out.printf("Stopwatch reset from %02d:%02d to 00:00.%n", elapsedTime / 60, elapsedTime % 60);
                    elapsedTime = 0;
                    break;
                case "exit":
                    running = false;
                    System.out.printf("\nExiting stopwatch. Final time: %02d:%02d. Goodbye!%n", elapsedTime / 60, elapsedTime % 60);
                    timerThread.interrupt();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }
}