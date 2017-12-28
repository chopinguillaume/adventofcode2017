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


    static int partie2(int nombre) {

        int taille = 15;
        int[][] grille = new int[taille][taille];

        int x = taille / 2;
        int y = taille / 2;

        grille[x][y] = 1;

        int cercle = 0;

        int dx = 0;
        int dy = 0;

        int dir = 0; //0 : droite, 1 : haut, 2 : gauche, 3 : bas

        int valeur = 1;

        while (valeur <= nombre) {
            switch (dir) {
                case 0:
                    if (dx < cercle) dx++;
                    if (dx == cercle && dy > -cercle) dir = 1;
                    break;
                case 1:
                    if (dy < cercle) dy++;
                    if (dy == cercle) dir = 2;
                    break;
                case 2:
                    if (dx > -cercle) dx--;
                    if (dx == -cercle) dir = 3;
                    break;
                case 3:
                    if (dy > -cercle) dy--;
                    if (dy == -cercle) dir = 0;
                    break;
            }

            //Fin du cercle, en bas a droite
            if (dx == cercle && dy == -cercle) {
                cercle++;
            }

            valeur = valeur(grille, x + dx, y + dy);
            grille[x + dx][y + dy] = valeur;
        }

        return valeur;
    }


    private static int valeur(int[][] grille, int x1, int y1) {

        int somme = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                somme += grille[x1 + dx][y1 + dy];
            }
        }

        return somme;
    }


    public static void main(String[] args) {

        partie2(60);
    }

}
