package day06;

import input.Fichier;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test06 {


    @Test
    public void test01() {

        assertEquals(5, MemoryBanks.nombreCycles("0 2   7   0"));
        assertEquals(4, MemoryBanks.nombreCycles("2 4   1   2"));

        System.out.println(MemoryBanks.nombreCycles(Fichier.premiereLigne("day06")));
    }


    @Test

    public void test02() {

        assertEquals(4, MemoryBanks.nombreCyclesPartie2("0 2   7   0"));
        assertEquals(4, MemoryBanks.nombreCyclesPartie2("2 4   1   2"));

        System.out.println(MemoryBanks.nombreCyclesPartie2(Fichier.premiereLigne("day06")));
    }

}
