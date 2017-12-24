package day01;

import input.Fichier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test01 {

    @Test
    public void test01() {

        assertEquals(3, Captcha.somme("1122"));
        assertEquals(4, Captcha.somme("1111"));
        assertEquals(0, Captcha.somme("1234"));
        assertEquals(9, Captcha.somme("91212129"));

        System.out.println(Captcha.somme(Fichier.premiereLigne("day01")));
    }

    @Test
    public void test02() {

        assertEquals(6, Captcha.somme2("1212"));
        assertEquals(0, Captcha.somme2("1221"));
        assertEquals(4, Captcha.somme2("123425"));
        assertEquals(12, Captcha.somme2("123123"));
        assertEquals(4, Captcha.somme2("12131415"));

        System.out.println(Captcha.somme2(Fichier.premiereLigne("day01")));
    }
}
