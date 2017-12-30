package day04;

import input.Fichier;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.TreeSet;


public class Passphrase {


    public static boolean isValide(String passphrase) {

        String[] mots = passphrase.split(" ");
        TreeSet<String> motsRencontres = new TreeSet<>();

        boolean valide = true;

        for (String mot : mots) {
            if (motsRencontres.contains(mot)) {
                valide = false;
                break;
            }
            motsRencontres.add(mot);
        }

        return valide;
    }


    public static int totalValide(String fichier) {

        int total = 0;

        try {
            BufferedReader reader = Fichier.reader(fichier);

            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (isValide(ligne)) {
                    total++;
                }
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return total;
    }


    public static boolean isValideAnagramme(String passphrase) {

        String[] mots = passphrase.split(" ");

        for (int i = 0; i < mots.length; i++) {
            for (int j = i + 1; j < mots.length; j++) {
                if (isAnagramme(mots[i], mots[j])) {
                    return false;
                }
            }
        }

        return true;
    }


    private static boolean isAnagramme(String mot1, String mot2) {

        if (mot1.length() != mot2.length())
            return false;

        ArrayList<Character> caracteres1 = new ArrayList<>();

        for (char c : mot1.toCharArray()) {
            caracteres1.add(c);
        }

        for (char c : mot2.toCharArray()) {

            if (caracteres1.contains(c)) {
                caracteres1.remove((Character) c);
            } else {
                return false;
            }
        }

        return true;
    }


    public static int totalValideAnagramme(String fichier) {

        int total = 0;

        try {
            BufferedReader reader = Fichier.reader(fichier);

            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (isValideAnagramme(ligne)) {
                    total++;
                }
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return total;
    }
}
