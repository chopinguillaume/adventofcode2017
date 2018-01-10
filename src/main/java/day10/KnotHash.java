package day10;

import java.util.ArrayList;
import java.util.Collections;

class KnotHash {


    public static int hashMultiply(int taille, String input) {

        int[] liste = new int[taille];

        for (int i = 0; i < liste.length; i++) {
            liste[i] = i;
        }

        ArrayList<Integer> etapes = new ArrayList<>();
        String[] splits = input.split(",");
        for (String split : splits) {
            etapes.add(Integer.parseInt(split.trim()));
        }

        int position = 0;
        int saut = 0;

        for (Integer etape : etapes) {

            ArrayList<Integer> inverser = new ArrayList<>();
            int i = 0;
            //Ajouter les nombres a la liste inverser
            while (i < etape) {
                int nombre = liste[(position + i) % taille];
                inverser.add(nombre);
                i++;
            }
            //Inverser la liste
            Collections.reverse(inverser);

            //Remettre la liste dans le tableau
            for (int j = 0; j < inverser.size(); j++) {
                liste[(j + position) % taille] = inverser.get(j);
            }

            //Changer la position courante
            position = position + etape + saut;

            //Incrementer le saut
            saut++;
        }

        return liste[0] * liste[1];
    }
}
