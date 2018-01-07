package day09;

class Transition {


    final boolean compterGarbage;


    final int depart;


    final char caractereLu;


    final int arrivee;


    Transition(int depart, char caractereLu, int arrivee) {

        this(depart, caractereLu, arrivee, false);
    }


    Transition(int depart, char caractereLu, int arrivee, boolean compterGarbage) {

        this.depart = depart;
        this.caractereLu = caractereLu;
        this.arrivee = arrivee;
        this.compterGarbage = compterGarbage;
    }
}
