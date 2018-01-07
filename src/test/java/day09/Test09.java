package day09;

import input.Fichier;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test09 {


    @Test
    public void test01() {

        assertEquals(1, GarbageStream.totalScore("{}"));
        assertEquals(6, GarbageStream.totalScore("{{{}}}"));
        assertEquals(5, GarbageStream.totalScore("{{},{}}"));
        assertEquals(16, GarbageStream.totalScore("{{{},{},{{}}}}"));
        assertEquals(1, GarbageStream.totalScore("{<a>,<a>,<a>,<a>}"));
        assertEquals(9, GarbageStream.totalScore("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
        assertEquals(9, GarbageStream.totalScore("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
        assertEquals(3, GarbageStream.totalScore("{{<a!>},{<a!>},{<a!>},{<ab>}}"));

        System.out.println(GarbageStream.totalScore(Fichier.premiereLigne("day09")));
    }


    @Test
    public void test02() {

        assertEquals(0, GarbageStream.garbageNonIgnore("{}"));
        assertEquals(0, GarbageStream.garbageNonIgnore("{{{}}}"));
        assertEquals(0, GarbageStream.garbageNonIgnore("{{},{}}"));
        assertEquals(0, GarbageStream.garbageNonIgnore("{{{},{},{{}}}}"));
        assertEquals(4, GarbageStream.garbageNonIgnore("{<a>,<a>,<a>,<a>}"));
        assertEquals(8, GarbageStream.garbageNonIgnore("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
        assertEquals(0, GarbageStream.garbageNonIgnore("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
        assertEquals(17, GarbageStream.garbageNonIgnore("{{<a!>},{<a!>},{<a!>},{<ab>}}"));

        System.out.println(GarbageStream.garbageNonIgnore(Fichier.premiereLigne("day09")));
    }

}
