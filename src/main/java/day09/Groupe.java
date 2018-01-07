package day09;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Groupe {


    private final Groupe parent;


    private final int score;


    private final ArrayList<Groupe> enfants = new ArrayList<>();


    Groupe(Groupe parent) {

        this.parent = parent;
        if (parent != null) {
            score = parent.score + 1;
            parent.enfants.add(this);
        } else {
            score = 0;
        }
    }


    public Groupe getParent() {

        return parent;
    }


    @Override
    public String toString() {

        StringJoiner joiner;
        if (parent != null)
            joiner = new StringJoiner(",", "{", "}");
        else
            joiner = new StringJoiner(",");

        for (Groupe enfant : enfants) {
            joiner.add(enfant.toString());
        }

        return joiner.toString();
    }


    public int getScoreTotal() {

        int total = score;

        for (Groupe enfant : enfants) {
            total += enfant.getScoreTotal();
        }

        return total;
    }

}
