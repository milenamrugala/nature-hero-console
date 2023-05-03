package pl.milenamrugala.naturehero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class NatureHero {

    public static void main(String[] args) {

        int correctAnswer = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        String name = scanner.nextLine();

        Map<String, String> map = getMapFromFile("bin-colors.txt");

        List<String> items = new ArrayList<>(map.keySet());
        Collections.shuffle(items);

        System.out.println("Welcome to the Nature Hero quiz game, " + name + "!");
        System.out.println("Identify the correct bin color for each waste type:");
        System.out.println("- blue: paper\n- green: glass\n- brown: bio waste\n-" +
                " yellow: metal and plastic\n- black: mixed or non-recyclable waste\nLet's get started!\n");

        for (String item : items) {
            System.out.println(String.format("Provide the correct bin color for \"%s\":", item));
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(map.get(item))) {
                correctAnswer++;
                System.out.println("Correct!");
            } else {
                System.out.println(String.format("Sorry, the correct bin color for \"%s\" is %s.", item, map.get(item)));
            }
        }

        int totalQuestions = map.size();
        System.out.println(String.format("You got %d out of %d answers correct.", correctAnswer, totalQuestions));

        if (correctAnswer >= 25) {
            System.out.println("Congratulations, you're a Nature Hero, " + name + "!");
        } else if (correctAnswer >= 20) {
            System.out.println("Well done, you're a Nature Friend, " + name + "!");
        } else if (correctAnswer >= 15) {
            System.out.println("Good job, you're a Nature Supporter, " + name + "!");
        } else {
            System.out.println("Thanks for playing, " + name + "!");
        }

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Do you have any feedback for the Nature Hero quiz game? (y/n)");
            String feedbackInput = scanner.nextLine();
            if (feedbackInput.equalsIgnoreCase("y")) {
                System.out.println("Please provide your feedback:");
                String feedback = scanner.nextLine();
                try {
                    FileWriter writer = new FileWriter("nature-hero-feedback.txt", true);
                    writer.write("\n" + feedback);
                    writer.close();
                    System.out.println("Thank you for your feedback, " + name + "!");
                    validInput = true;
                } catch (IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }
            } else if (feedbackInput.equalsIgnoreCase("n")) {
                System.out.println("Thank you for playing the Nature Hero quiz game, " + name + "!");
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }

    private static Map<String, String> getMapFromFile(String fileName) {
        Map<String, String> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(":");
                if (line.length == 2) {
                    map.put(line[0].trim(), line[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return map;
    }
}