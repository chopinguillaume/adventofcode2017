package day03;

public class ManhattanDistance {


    static int distance(int nombre) {

        int inferieur = 1;
        int superieur = 1;
        int index = 0;

        int courant = 1;
        int incr = 1;
        while (courant < nombre) {
            int nouveau = courant + incr;
            incr += 8;
            inferieur = courant;
            superieur = nouveau;
            index++;

            courant = nouveau;
        }

        for (int i = 0; i < 3; i++) {
            int autreInferieur = inferieur + (index - 1) * 2;
            if (autreInferieur <= nombre) {
                inferieur = autreInferieur;
            }
        }

        int ecartInferieur = nombre - inferieur;
        int ecartSuperieur = superieur - nombre;

        int distance;
        if (ecartInferieur < ecartSuperieur) {
            distance = ecartInferieur + index - 1;
        } else {
            distance = ecartSuperieur + index;
        }

        return distance;
    }
}
