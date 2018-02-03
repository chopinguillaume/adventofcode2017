package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KnotHash {


    private final int taille;


    KnotHash(int taille) {

        this.taille = taille;
    }


    static int[] xorBlocs(int taillePaquets, int[] liste) {

        int nbBlocs = liste.length / taillePaquets;
        int[] xors = new int[nbBlocs];
        for (int blocIndex = 0; blocIndex < nbBlocs; blocIndex++) {
            int xor = 0;
            for (int xorIndex = 0; xorIndex < taillePaquets; xorIndex++) {
                xor = xor ^ liste[blocIndex * taillePaquets + xorIndex];
            }
            xors[blocIndex] = xor;
        }
        return xors;
    }


    static String xorBlocsToString(int[] xors) {

        StringBuilder hexa = new StringBuilder();

        for (int xor : xors) {
            String hex = Integer.toHexString(xor);
            if (hex.length() == 1) {
                hexa.append(0);
            }
            hexa.append(hex);
        }

        return hexa.toString().toLowerCase();
    }


    static List<Integer> longueursDeChaine(String input) {
        //Lire les caractères en ascii et faire la liste des longueurs.
        ArrayList<Integer> longueurs = new ArrayList<>();
        for (char c : input.toCharArray()) {
            longueurs.add((int) c);
        }

        //Ajout de 17, 31, 73, 47, 23 à la liste des longueurs
        longueurs.add(17);
        longueurs.add(31);
        longueurs.add(73);
        longueurs.add(47);
        longueurs.add(23);

        return longueurs;
    }


    public int hashMultiply(String input) {

        ArrayList<Integer> longueurs = new ArrayList<>();
        String[] splits = input.split(",");
        for (String split : splits) {
            longueurs.add(Integer.parseInt(split.trim()));
        }

        int[] liste = cycle(1, longueurs);

        return liste[0] * liste[1];
    }


    public String hash(String input) {

        List<Integer> longueurs = longueursDeChaine(input);

        //64 cycles : position et saut sont persistants entre les cycles
        //La liste des longueurs ne change pas entre les cycles
        int[] liste = cycle(64, longueurs);

        //XOR par blocs de 16
        int[] xors = xorBlocs(16, liste);

        //Ecrire les blocs en hexa
        return xorBlocsToString(xors);
    }


    int[] cycle(int nbCycles, List<Integer> longueurs) {

        int[] liste = new int[taille];

        for (int i = 0; i < liste.length; i++) {
            liste[i] = i;
        }

        int position = 0;
        int saut = 0;

        for (int cycle = 0; cycle < nbCycles; cycle++) {

            for (Integer etape : longueurs) {

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
                position = (position + etape + saut) % taille;

                //Incrementer le saut
                saut++;
            }

        }

        return liste;
    }
}
