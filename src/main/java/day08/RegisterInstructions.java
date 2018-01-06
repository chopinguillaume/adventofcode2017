package day08;

import input.Fichier;

import java.io.BufferedReader;
import java.util.HashMap;

public class RegisterInstructions {


    public static int plusGrandeValeur(String fichier) {

        try {
            HashMap<String, Integer> registres = new HashMap<>(); //K = registre, V = valeur

            BufferedReader reader = Fichier.reader(fichier);
            String ligne;
            while ((ligne = reader.readLine()) != null) {

                //Decouper instruction
                String[] parties = ligne.split("\\s+");
                String registre = parties[0];
                String operation = parties[1];
                int valeur = Integer.parseInt(parties[2]);
                String registreCondition = parties[4];
                String operationCondition = parties[5];
                int valeurCondition = Integer.parseInt(parties[6]);

                //Tester la condition
                int valeurRegistreCondition = registres.getOrDefault(registreCondition, 0);

                boolean condition = condition(operationCondition, valeurRegistreCondition, valeurCondition);

                if (condition) {
                    int valeurRegistre = registres.getOrDefault(registre, 0);
                    switch (operation) {
                        case "inc":
                            valeurRegistre += valeur;
                            break;
                        case "dec":
                            valeurRegistre -= valeur;
                            break;
                    }
                    registres.put(registre, valeurRegistre);
                }
            }

            //Parcourir les registres pour trouver la plus grande valeur
            int max = 0;
            for (Integer integer : registres.values()) {
                max = Math.max(max, integer);
            }

            return max;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static int plusGrandeValeurPossible(String fichier) {

        try {
            HashMap<String, Integer> registres = new HashMap<>(); //K = registre, V = valeur

            int maxPossible = 0;

            BufferedReader reader = Fichier.reader(fichier);
            String ligne;
            while ((ligne = reader.readLine()) != null) {

                //Decouper instruction
                String[] parties = ligne.split("\\s+");
                String registre = parties[0];
                String operation = parties[1];
                int valeur = Integer.parseInt(parties[2]);
                String registreCondition = parties[4];
                String operationCondition = parties[5];
                int valeurCondition = Integer.parseInt(parties[6]);

                //Tester la condition
                int valeurRegistreCondition = registres.getOrDefault(registreCondition, 0);

                boolean condition = condition(operationCondition, valeurRegistreCondition, valeurCondition);

                if (condition) {
                    int valeurRegistre = registres.getOrDefault(registre, 0);
                    switch (operation) {
                        case "inc":
                            valeurRegistre += valeur;
                            break;
                        case "dec":
                            valeurRegistre -= valeur;
                            break;
                    }
                    registres.put(registre, valeurRegistre);
                    maxPossible = Math.max(maxPossible, valeurRegistre);
                }
            }

            return maxPossible;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    private static boolean condition(String operationCondition, int valeurRegistreCondition, int valeurCondition) {

        boolean condition = false;
        switch (operationCondition) {
            case "<":
                condition = valeurRegistreCondition < valeurCondition;
                break;
            case ">":
                condition = valeurRegistreCondition > valeurCondition;
                break;
            case "<=":
                condition = valeurRegistreCondition <= valeurCondition;
                break;
            case ">=":
                condition = valeurRegistreCondition >= valeurCondition;
                break;
            case "==":
                condition = valeurRegistreCondition == valeurCondition;
                break;
            case "!=":
                condition = valeurRegistreCondition != valeurCondition;
                break;
        }
        return condition;

    }
}
