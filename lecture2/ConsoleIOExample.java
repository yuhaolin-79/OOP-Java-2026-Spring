import java.io.*;
public class ConsoleIOExample {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true); // true for auto-flush

        try {
            writer.println("Enter your name:");
            String name = reader.readLine(); // Read a line of input from the user
            writer.println("Hello, " + name + "!"); // Greet the user
        } catch (IOException e) {
            writer.println("An error occurred: " + e.getMessage());
        }
    }
}