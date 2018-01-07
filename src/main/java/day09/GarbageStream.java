package day09;

public class GarbageStream {


    public static int totalScore(String input) {

        AutomateLexer automate = new AutomateLexer();

        while (!input.isEmpty()) {

            automate.avancer(input.charAt(0));

            input = input.substring(1);
        }

        return automate.groupeCourant.getScoreTotal();
    }


    public static int garbageNonIgnore(String input) {

        AutomateLexer automate = new AutomateLexer();

        while (!input.isEmpty()) {

            automate.avancer(input.charAt(0));

            input = input.substring(1);
        }

        return automate.getGarbageNonIgnore();
    }
}
