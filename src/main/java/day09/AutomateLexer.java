package day09;

import java.util.ArrayList;

class AutomateLexer {


    Groupe groupeCourant = new Groupe(null);


    private int etatCourant;


    private int totalGarbage = 0;


    private ArrayList<Transition> relations = new ArrayList<>();


    private ArrayList<Transition> relationsDefaut = new ArrayList<>();


    AutomateLexer() {

        etatCourant = 0;

        relations.add(new Transition(0, '{', 1));
        relations.add(new Transition(0, '<', 3));

        relations.add(new Transition(1, '{', 1));
        relations.add(new Transition(1, '}', 2));
        relations.add(new Transition(1, '<', 3));

        relations.add(new Transition(2, ',', 0));
        relations.add(new Transition(2, '}', 2));

        relations.add(new Transition(3, '>', 4));
        relations.add(new Transition(3, '!', 5));
        relationsDefaut.add(new Transition(3, '*', 6, true));

        relations.add(new Transition(4, ',', 0));
        relations.add(new Transition(4, '}', 2));

        relationsDefaut.add(new Transition(5, '*', 6));

        relations.add(new Transition(6, '>', 4));
        relations.add(new Transition(6, '!', 5));
        relationsDefaut.add(new Transition(6, '*', 6, true));
    }


    private static Transition transitionCorrecte(ArrayList<Transition> relations, int etatCourant, char caractere) {

        Transition transitionAppliquee = null;
        for (Transition relation : relations) {
            if (relation.depart == etatCourant)
                if (relation.caractereLu == caractere || relation.caractereLu == '*') {
                    transitionAppliquee = relation;
                    break;
                }
        }
        return transitionAppliquee;
    }


    public void avancer(char caractere) {

        Transition transitionAppliquee = transitionCorrecte(relations, etatCourant, caractere);
        if (transitionAppliquee == null) {
            transitionAppliquee = transitionCorrecte(relationsDefaut, etatCourant, caractere);
        }

        etatCourant = transitionAppliquee.arrivee;

        if (transitionAppliquee.compterGarbage)
            totalGarbage++;

        //Modifier l'arbre des groupes selon l'état courant
        if (etatCourant == 1) {
            //Ouvrir un nouveau groupe, il devient le groupe courant
            groupeCourant = new Groupe(groupeCourant);

        } else if (etatCourant == 2) {
            //Fermer le groupe courant, son parent devient le nouveau groupe courant
            groupeCourant = groupeCourant.getParent();
        }

    }


    public int getGarbageNonIgnore() {

        return totalGarbage;
    }
}
