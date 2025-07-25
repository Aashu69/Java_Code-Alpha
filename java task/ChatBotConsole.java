import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBotConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined responses
        Map<String, String> responses = new HashMap<>();
        responses.put("hi", "Hello! How can I assist you?");
        responses.put("hello", "Hi there! What would you like to know?");
        responses.put("how are you", "I'm just a bunch of Java code, but I'm doing great!");
        responses.put("what is your name", "I'm your Java ChatBot 🤖.");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("help", "You can ask me common questions, and I'll try to help.");

        System.out.println("🤖 Welcome to Java ChatBot!");
        System.out.println("Type 'bye' to end the chat.\n");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("bye")) {
                System.out.println("Bot: " + responses.get("bye"));
                break;
            }

            boolean matched = false;
            for (String keyword : responses.keySet()) {
                if (input.contains(keyword)) {
                    System.out.println("Bot: " + responses.get(keyword));
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                System.out.println("Bot: I'm still learning. Can you rephrase that?");
            }
        }

        scanner.close();
    }
}
