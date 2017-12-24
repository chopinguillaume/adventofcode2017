package day02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test02 {


    @Test
    public void test01() {

        assertEquals(18, Checksum.total("day02test"));

        System.out.println(Checksum.total("day02"));
    }


    @Test
    public void test02() {

        assertEquals(9, Checksum.total2("day02test2"));

        System.out.println(Checksum.total2("day02"));

    }

}
