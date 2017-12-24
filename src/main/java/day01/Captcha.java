package day01;

public class Captcha {

    public static int somme(String captcha) {
        return sommeInterne(captcha, 1);
    }

    public static int somme2(String captcha) {
        return sommeInterne(captcha, captcha.length() / 2);
    }

    private static int sommeInterne(String captcha, int ecart) {

        int somme = 0;

        for (int i = 0; i < captcha.toCharArray().length; i++)
            if (captcha.charAt(i) == captcha.charAt((i + ecart) % captcha.length()))
                somme += Integer.parseInt(String.valueOf(captcha.charAt(i)));

        return somme;
    }
}
