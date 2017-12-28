package day03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test03 {


    @Test
    public void test01() {

        assertEquals(0, ManhattanDistance.distance(1));
        assertEquals(1, ManhattanDistance.distance(2));
        assertEquals(2, ManhattanDistance.distance(3));
        assertEquals(2, ManhattanDistance.distance(23));
        assertEquals(3, ManhattanDistance.distance(12));
        assertEquals(4, ManhattanDistance.distance(17));
        assertEquals(6, ManhattanDistance.distance(37));
        assertEquals(6, ManhattanDistance.distance(127));
        assertEquals(31, ManhattanDistance.distance(1024));

        System.out.println(ManhattanDistance.distance(277678));
    }


    @Test
    public void test02() {

        assertEquals(2, ManhattanDistance.partie2(1));
        assertEquals(11, ManhattanDistance.partie2(10));
        assertEquals(54, ManhattanDistance.partie2(27));
        assertEquals(122, ManhattanDistance.partie2(60));
        assertEquals(806, ManhattanDistance.partie2(800));

        System.out.println(ManhattanDistance.partie2(277678));

    }

}
