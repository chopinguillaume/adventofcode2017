package day07;

import java.util.ArrayList;
import java.util.Comparator;

class Programme {


    private final String nom;


    private final ArrayList<Programme> sousProgrammes;


    private final int poids;


    private Programme parent;


    private int poidsTotal;


    Programme(String nom, int poids) {

        this.nom = nom;
        this.poids = poids;
        sousProgrammes = new ArrayList<>();
    }


    public String getNom() {

        return nom;
    }


    public ArrayList<Programme> getSousProgrammes() {

        return sousProgrammes;
    }


    public Programme getParent() {

        return parent;
    }


    public void setParent(Programme parent) {

        this.parent = parent;
    }


    public int getPoidsTotal() {

        if (poidsTotal != 0)
            return poidsTotal;

        poidsTotal = poids;

        for (Programme sousProgramme : sousProgrammes) {
            poidsTotal += sousProgramme.getPoidsTotal();
        }

        return poidsTotal;
    }


    public int getPoids() {

        return poids;
    }


    public Programme programmeMauvaisPoids() {

        if (sousProgrammes.isEmpty())
            return this;

        sousProgrammes.sort(Comparator.comparingInt(Programme::getPoidsTotal));

        Programme different;
        if (sousProgrammes.get(0).getPoidsTotal() != sousProgrammes.get(1).getPoidsTotal()) {
            different = sousProgrammes.get(0);
        } else if (sousProgrammes.get(0).getPoidsTotal() != sousProgrammes.get(sousProgrammes.size() - 1).getPoidsTotal()) {
            different = sousProgrammes.get(sousProgrammes.size() - 1);
        } else {
            //Si tous égaux, alors différent = this
            return this;
        }

        return different.programmeMauvaisPoids();
    }
}
