package day10;

import input.Fichier;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test10 {


    @Test
    public void test01() {

        assertEquals(12, KnotHash.hashMultiply(5, "3, 4, 1, 5"));

        System.out.println(KnotHash.hashMultiply(256, Fichier.premiereLigne("day10")));

    }

}
