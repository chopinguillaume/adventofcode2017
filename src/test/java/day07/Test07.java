package day07;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test07 {


    @Test
    public void test01() {

        assertEquals("tknk", ProgramTower.programmeDuBas("day07test"));

        System.out.println(ProgramTower.programmeDuBas("day07"));
    }


    @Test
    public void test02() {

        assertEquals(60, ProgramTower.poidsCorrige("day07test"));
        assertEquals(61, ProgramTower.poidsCorrige("day07test2"));

        System.out.println(ProgramTower.poidsCorrige("day07"));
    }

}
