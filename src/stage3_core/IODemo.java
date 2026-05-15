package stage3_core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) {
        String filename = "src/stage3_core/hello_io.txt";

        // 1. Write to file using try-with-resources
        //    Resources declared in try() are auto-closed (like RAII)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Hello from Java IO!");
            writer.newLine();
            writer.write("Line 2: Learning IO is easy.");
            writer.newLine();
            writer.write("Line 3: Auto-close with try-with-resources.");
            System.out.println("Written to " + filename);
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }

        // 2. Read from file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\nReading from " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
