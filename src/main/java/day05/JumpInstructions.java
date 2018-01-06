package day05;

import input.Fichier;

import java.io.BufferedReader;
import java.util.ArrayList;

public class JumpInstructions {


    public static int nombreSauts(String fichier) {

        int nombreSauts = 0;
        try {
            BufferedReader reader = Fichier.reader(fichier);

            ArrayList<Integer> instructions = new ArrayList<>();

            String ligne;
            while ((ligne = reader.readLine()) != null) {
                instructions.add(Integer.parseInt(ligne));
            }

            int prochaineInstruction = 0;

            while (prochaineInstruction >= 0 && prochaineInstruction < instructions.size()) {

                int valeurSaut = instructions.get(prochaineInstruction);
                int indexInstruction = prochaineInstruction;
                prochaineInstruction += valeurSaut;

                nombreSauts++;

                instructions.remove(indexInstruction);
                instructions.add(indexInstruction, valeurSaut + 1);
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return nombreSauts;
    }


    public static int nombreSautsPartie2(String fichier) {

        int nombreSauts = 0;
        try {
            BufferedReader reader = Fichier.reader(fichier);

            ArrayList<Integer> instructions = new ArrayList<>();

            String ligne;
            while ((ligne = reader.readLine()) != null) {
                instructions.add(Integer.parseInt(ligne));
            }

            int prochaineInstruction = 0;

            while (prochaineInstruction >= 0 && prochaineInstruction < instructions.size()) {

                int valeurSaut = instructions.get(prochaineInstruction);
                int indexInstruction = prochaineInstruction;
                prochaineInstruction += valeurSaut;

                nombreSauts++;

                instructions.remove(indexInstruction);

                if (valeurSaut >= 3)
                    instructions.add(indexInstruction, valeurSaut - 1);
                else
                    instructions.add(indexInstruction, valeurSaut + 1);
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return nombreSauts;
    }
}
