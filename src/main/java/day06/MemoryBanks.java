package day06;

import java.util.HashSet;
import java.util.Set;

public class MemoryBanks {


    public static int nombreCycles(String input) {

        String[] splits = input.split("\\s+");
        int[] banques = new int[splits.length];

        for (int i = 0; i < splits.length; i++) {
            banques[i] = Integer.parseInt(splits[i]);
        }

        int nombreCycles = 0;
        Set<String> configurationsRencontrees = new HashSet<>();
        configurationsRencontrees.add(configuration(banques));

        boolean continuer = true;

        while (continuer) {

            //Chercher la banque la plus grosse
            int indexMax = 0;
            for (int i = 0; i < banques.length; i++)
                if (banques[i] > banques[indexMax])
                    indexMax = i;

            //Redistribuer ses blocs
            int nombreBlocs = banques[indexMax];
            banques[indexMax] = 0;

            int indexDistrib = (indexMax + 1) % banques.length;
            while (nombreBlocs > 0) {
                banques[indexDistrib] = banques[indexDistrib] + 1;
                nombreBlocs--;
                indexDistrib = (indexDistrib + 1) % banques.length;
            }

            nombreCycles++;

            //Tester l'existence de la configuration
            String nouvelleConfig = configuration(banques);

            if (configurationsRencontrees.contains(nouvelleConfig))
                continuer = false;
            else
                configurationsRencontrees.add(nouvelleConfig);
        }

        return nombreCycles;
    }


    // Boucle "à vide" pour trouver le premier doublon, puis appelle le
    // compteur de la partie 1 sur ce doublon pour connaitre la taille du cycle
    public static int nombreCyclesPartie2(String input) {

        String[] splits = input.split("\\s+");
        int[] banques = new int[splits.length];

        for (int i = 0; i < splits.length; i++) {
            banques[i] = Integer.parseInt(splits[i]);
        }

        Set<String> configurationsRencontrees = new HashSet<>();
        configurationsRencontrees.add(configuration(banques));

        boolean continuer = true;

        while (continuer) {

            //Chercher la banque la plus grosse
            int indexMax = 0;
            for (int i = 0; i < banques.length; i++)
                if (banques[i] > banques[indexMax])
                    indexMax = i;

            //Redistribuer ses blocs
            int nombreBlocs = banques[indexMax];
            banques[indexMax] = 0;

            int indexDistrib = (indexMax + 1) % banques.length;
            while (nombreBlocs > 0) {
                banques[indexDistrib] = banques[indexDistrib] + 1;
                nombreBlocs--;
                indexDistrib = (indexDistrib + 1) % banques.length;
            }

            //Tester l'existence de la configuration
            String nouvelleConfig = configuration(banques);

            if (configurationsRencontrees.contains(nouvelleConfig))
                continuer = false;
            else
                configurationsRencontrees.add(nouvelleConfig);
        }

        return nombreCycles(configuration(banques));
    }


    private static String configuration(int[] banques) {

        StringBuilder stockage = new StringBuilder();
        for (int banque : banques) {
            stockage.append(banque);
            stockage.append(" ");
        }
        return stockage.toString();
    }
}
