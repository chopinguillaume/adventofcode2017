package day07;

import input.Fichier;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ProgramTower {


    public static String programmeDuBas(String fichier) {

        return racineTour(fichier).getNom();
    }


    public static int poidsCorrige(String fichier) {

        //Construire les tours
        Programme racine = racineTour(fichier);
        if (racine == null)
            return 0;

        //Calculer pour chaque programme le poids qu'il fait au total (lui + ses tours)
        racine.getPoidsTotal();

        //Noter la différence entre la tour en défaut et les autres
        ArrayList<Integer> poidsTours = new ArrayList<>();
        for (Programme programme : racine.getSousProgrammes()) {
            poidsTours.add(programme.getPoidsTotal());
        }
        //Trouver l'intrus dans tous les poids, et calculer l'ajout à appliquer pour qu'il ait la meme valeur que les autres
        int difference;
        poidsTours.sort(Integer::compareTo);
        if (!poidsTours.get(0).equals(poidsTours.get(1)))
            difference = poidsTours.get(1) - poidsTours.get(0); //Premier element different des autres
        else
            difference = poidsTours.get(0) - poidsTours.get(poidsTours.size() - 1); //Dernier element different des autres

        //En partant du bas, rechercher la base de la tour avec le mauvais poids
        Programme programmeDefaut = racine.programmeMauvaisPoids();

        //Calculer son nouveau poids à partir de la différence requise
        return programmeDefaut.getPoids() + difference;
    }


    private static Programme racineTour(String fichier) {

        try {
            BufferedReader reader = Fichier.reader(fichier);

            HashMap<String, Programme> programmes = new HashMap<>(); //K = nom, V = programme
            HashMap<String, String> relations = new HashMap<>(); //K = fils, V = parent

            // Boucle : Lire le fichier
            String ligne;
            while ((ligne = reader.readLine()) != null) {

                // Lire les infos données
                // Format avec sous-programmes : "fwft (72) -> ktlj, cntj, xhth"
                // Format sans sous-programmes : "fwft (72)"
                String[] parties = ligne.split("->");
                //parties[0] contient les infos du programme
                //parties[1] si existe, contient la liste des sous-programmes

                String[] nomEtPoids = parties[0].replaceAll("[()]", "").split("\\s+");
                String nom = nomEtPoids[0];
                int poids = Integer.parseInt(nomEtPoids[1]);

                // Construire un programme
                Programme programme = new Programme(nom, poids);

                if (parties.length > 1) {
                    //Le programme a des sous-programmes

                    String[] sousProgrammes = parties[1].replaceAll(",", "").trim().split("\\s+");
                    for (String sousProgramme : sousProgrammes) {
                        relations.put(sousProgramme, programme.getNom());
                    }
                }

                // Le ranger dans la map "programmes"
                programmes.put(programme.getNom(), programme);

            }

            // Appliquer les relations stockées
            relations.forEach((fils, parent) -> {
                Programme programmeFils = programmes.get(fils);
                Programme programmeParent = programmes.get(parent);
                if (programmeFils != null && programmeParent != null) {
                    programmeFils.setParent(programmeParent);
                    programmeParent.getSousProgrammes().add(programmeFils);
                }
            });

            // Prendre un programme aléatoire
            Programme programmeParcours = programmes.values().iterator().next();

            // Remonter ses parents jusqu'au programme du bas
            while (programmeParcours.getParent() != null) {
                programmeParcours = programmeParcours.getParent();
            }

            return programmeParcours;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
