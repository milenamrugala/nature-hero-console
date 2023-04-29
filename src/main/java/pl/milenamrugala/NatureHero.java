package pl.milenamrugala;


import java.util.*;

public class NatureHero {

    public static void main(String[] args) {

        int correctAnswer = 0;

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> map = getMap();
        List<String> items = new ArrayList<>(map.keySet());
        Collections.shuffle(items);
        for (String string : items) {
            System.out.println(String.join
                    (" ", "Provide correct color of the bin" +
                            " in which you will place the following item: ", string));

            String answer = scanner.nextLine();
            if (answer.equals(map.get(string))) {
                correctAnswer++;
                System.out.println("Correct!");
            } else {
                System.out.println(String.join(" ", "Wrong answer." +
                        " The correct color of the bin for", string, "is", map.get(string)));
            }
        }

        int totalQuestions = map.size();
        System.out.println(String.format("Number of correct answers: %d/%d", correctAnswer, totalQuestions));


        switch (correctAnswer) {
            case 30:
            case 29:
            case 28:
            case 27:
            case 26:
            case 25:
                System.out.println("Congratulations, you are a Nature Hero!");
                break;
            case 24:
            case 23:
            case 22:
            case 21:
            case 20:
                System.out.println("Well done, you are a Nature Friend!");
                break;
            case 19:
            case 18:
            case 17:
            case 16:
            case 15:
                System.out.println("Good job, you are a Nature Supporter!");
                break;
            default:
                System.out.println("Thanks for playing!");
        }
    }


    private static HashMap<String, String> getMap() {

        HashMap<String, String> map = new HashMap<>();
        map.put("printer paper", "blue"); // blue for paper
        map.put("wine bottles", "green"); // green for glass
        map.put("coffee grounds", "brown"); // brown for bio waste
        map.put("beer cans", "yellow"); // yellow for metal
        map.put("meat", "black"); // black for mixed
        map.put("eggshells", "brown");
        map.put("pickle jars", "green");
        map.put("notepads", "blue");
        map.put("grass clippings", "brown");
        map.put("broken mirror", "black");
        map.put("envelops", "blue");
        map.put("aluminum foil", "yellow");
        map.put("heat-resistant glass", "black");
        map.put("vegetable scraps", "brown");
        map.put("postcards", "blue");
        map.put("flyers", "blue");
        map.put("bones", "black");
        map.put("tea bags", "brown");
        map.put("jam jars", "green");
        map.put("plastic water bottles", "yellow");
        map.put("olive oil bottles", "green");
        map.put("magazines", "blue");
        map.put("brochures", "blue");
        map.put("fish bones", "black");
        map.put("fruit scraps", "brown");
        map.put("leaves", "brown");
        map.put("glass jars", "green");
        map.put("plastic containers for yogurt", "yellow");
        map.put("diapers", "black");
        map.put("aerosol cans", "yellow");

        return map;
    }
}