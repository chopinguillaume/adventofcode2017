package day04;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test04 {


    @Test
    public void test01() {

        assertTrue(Passphrase.isValide("aa bb cc dd ee"));
        assertFalse(Passphrase.isValide("aa bb cc dd aa"));
        assertTrue(Passphrase.isValide("aa bb cc dd aaa"));

        System.out.println(Passphrase.totalValide("day04"));
    }


    @Test
    public void test02() {

        assertTrue(Passphrase.isValideAnagramme("abcde fghij"));
        assertFalse(Passphrase.isValideAnagramme("abcde xyz ecdab"));
        assertTrue(Passphrase.isValideAnagramme("a ab abc abd abf abj"));
        assertTrue(Passphrase.isValideAnagramme("iiii oiii ooii oooi oooo"));
        assertFalse(Passphrase.isValideAnagramme("oiii ioii iioi iiio"));

        System.out.println(Passphrase.totalValideAnagramme("day04"));

    }

}
