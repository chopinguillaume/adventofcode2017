package input;

import java.io.*;

public class Fichier {

    public static File ouvrir(String nom) {
        return new File(Fichier.class.getResource(nom).getFile());
    }

    public static BufferedReader reader(String fichier) throws FileNotFoundException {
        File file = Fichier.ouvrir(fichier);
        return new BufferedReader(new FileReader(file));
    }

    public static String premiereLigne(String fichier) {
        try {
            return reader(fichier).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
