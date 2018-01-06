package day08;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test08 {


    @Test
    public void test01() {

        assertEquals(1, RegisterInstructions.plusGrandeValeur("day08test"));

        System.out.println(RegisterInstructions.plusGrandeValeur("day08"));
    }


    @Test
    public void test02() {

        assertEquals(10, RegisterInstructions.plusGrandeValeurPossible("day08test"));

        System.out.println(RegisterInstructions.plusGrandeValeurPossible("day08"));
    }

}
