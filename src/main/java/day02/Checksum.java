package day02;

import input.Fichier;

import java.io.BufferedReader;

public class Checksum {


    public static int total(String fichier) {

        int total = 0;

        try {
            BufferedReader reader = Fichier.reader(fichier);

            String ligne;
            while ((ligne = reader.readLine()) != null && !ligne.isEmpty()) {
                total += ecartLigne(ligne);
            }
            reader.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
            return 0;
        }
        return total;
    }


    private static int ecartLigne(String ligne) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] nombres = ligne.split("\\s+");

        for (String nombre : nombres) {
            int valeur = Integer.parseInt(String.valueOf(nombre));
            max = Math.max(max, valeur);
            min = Math.min(min, valeur);
        }
        return max - min;
    }


    public static int total2(String fichier) {

        int total = 0;

        try {
            BufferedReader reader = Fichier.reader(fichier);

            String ligne;
            while ((ligne = reader.readLine()) != null && !ligne.isEmpty()) {
                total += divisionLigne(ligne);
            }
            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return total;

    }


    private static int divisionLigne(String ligne) {

        String[] nombres = ligne.split("\\s+");

        for (int i = 0; i < nombres.length; i++) {
            double valeur = Double.parseDouble(nombres[i]);
            int j = i + 1;
            while (j < nombres.length) {
                double valeur2 = Double.parseDouble(nombres[j]);
                double division = valeur / valeur2;
                double division2 = valeur2 / valeur;

                if (Math.floor(division) == division) {
                    return (int) division;
                } else if (Math.floor(division2) == division2) {
                    return (int) division2;
                }
                j++;
            }
        }

        return 0;
    }
}
