package day05;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test05 {


    @Test
    public void test01() {

        assertEquals(5, JumpInstructions.nombreSauts("day05test"));

        System.out.println(JumpInstructions.nombreSauts("day05"));
    }


    @Test
    public void test02() {

        assertEquals(10, JumpInstructions.nombreSautsPartie2("day05test"));

        System.out.println(JumpInstructions.nombreSautsPartie2("day05"));
    }

}
