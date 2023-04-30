package pl.milenamrugala.naturehero;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class NatureHero {

    public static void main(String[] args) {
        int correctAnswer = 0;

        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = getMapFromFile("src/main/bin-colors.txt");

        List<String> items = new ArrayList<>(map.keySet());
        Collections.shuffle(items);

        System.out.println("Welcome to the Nature Hero game! ");
        System.out.println("In this game, you will be shown a series of items," +
                " and you have to correctly identify the color of the bin in" +
                " which they should be placed for recycling. ");
        System.out.println("Here are the different colors and what types of waste they represent:");
        System.out.println("   - blue: paper");
        System.out.println("   - green: glass");
        System.out.println("   - brown: bio waste");
        System.out.println("   - yellow: metal and plastic");
        System.out.println("   - black: mixed or non-recyclable waste");
        System.out.println("Let's get started!\n");

        for (String item : items) {
            System.out.println(String.format("Provide the correct color of the bin in which you should place \"%s\":", item));
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(map.get(item))) {
                correctAnswer++;
                System.out.println("Correct!");
            } else {
                System.out.println(String.format("Sorry, the correct color for \"%s\" is %s.", item, map.get(item)));
            }
        }

        int totalQuestions = map.size();
        System.out.println(String.format("You got %d out of %d correct.", correctAnswer, totalQuestions));

        if (correctAnswer >= 25) {
            System.out.println("Congratulations, you're a Nature Hero!");
        } else if (correctAnswer >= 20) {
            System.out.println("Well done, you're a Nature Friend!");
        } else if (correctAnswer >= 15) {
            System.out.println("Good job, you're a Nature Supporter!");
        } else {
            System.out.println("Thanks for playing!");
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