package day10;

import input.Fichier;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Test10 {


    @Test
    public void test01() {

        assertEquals(12, new KnotHash(5).hashMultiply("3, 4, 1, 5"));

        System.out.println(new KnotHash(256).hashMultiply(Fichier.premiereLigne("day10")));

    }


    @Test
    public void test02() {

        /*
        Longueurs
         */
        assertTrue(KnotHash.longueursDeChaine("1,2,3").equals(Arrays.asList(49, 44, 50, 44, 51, 17, 31, 73, 47, 23)));

        /*
        Cycle
         */
        assertTrue(Arrays.equals(new int[]{0, 1, 2, 3, 4}, new KnotHash(5).cycle(0, Arrays.asList(3, 4, 1, 5))));
        assertTrue(Arrays.equals(new int[]{3, 4, 2, 1, 0}, new KnotHash(5).cycle(1, Arrays.asList(3, 4, 1, 5))));
        assertTrue(Arrays.equals(new int[]{2, 1, 4, 3, 0}, new KnotHash(5).cycle(2, Arrays.asList(3, 4, 1, 5))));
        assertTrue(Arrays.equals(new int[]{0, 4, 3, 1, 2}, new KnotHash(5).cycle(3, Arrays.asList(3, 4, 1, 5))));

        /*
        64 Cycles
         */
        int[] sparseChaineVide = new int[]{38, 171, 116, 63, 70, 137, 168, 29, 198, 55, 160, 15, 34, 95, 58, 7, 188, 189, 238, 141, 30, 31, 124, 241, 20, 1, 244, 203, 234, 73, 236, 211, 122, 197, 94, 227, 142, 57, 72, 239, 54, 81, 154, 217, 10, 13, 186, 161, 6, 17, 128, 105, 106, 69, 44, 51, 248, 23, 136, 173, 52, 39, 40, 5, 254, 195, 64, 187, 192, 37, 230, 153, 56, 177, 84, 147, 96, 249, 252, 121, 166, 143, 62, 169, 90, 99, 196, 155, 132, 159, 162, 229, 76, 117, 164, 127, 150, 21, 88, 27, 242, 67, 114, 115, 226, 191, 190, 53, 2, 65, 206, 205, 24, 251, 14, 75, 74, 247, 80, 11, 50, 181, 46, 101, 100, 179, 48, 131, 32, 97, 102, 201, 170, 93, 104, 103, 182, 125, 12, 43, 220, 113, 158, 167, 68, 47, 66, 33, 112, 135, 194, 185, 218, 219, 8, 245, 130, 253, 204, 243, 202, 109, 92, 209, 156, 133, 250, 107, 4, 183, 60, 215, 172, 231, 240, 83, 98, 193, 82, 139, 210, 91, 146, 85, 184, 163, 140, 145, 178, 35, 232, 151, 214, 213, 200, 199, 18, 221, 212, 9, 152, 123, 78, 3, 228, 25, 26, 225, 0, 61, 138, 255, 222, 233, 110, 129, 208, 207, 176, 235, 108, 77, 148, 19, 180, 79, 28, 149, 224, 237, 86, 157, 216, 111, 22, 89, 16, 41, 144, 71, 134, 59, 246, 165, 174, 223, 118, 119, 36, 175, 126, 87, 120, 45, 42, 49}; //Resultat récup sur reddit
        List<Integer> longueursChaineVide = KnotHash.longueursDeChaine("");
        assertTrue(longueursChaineVide.equals(Arrays.asList(17, 31, 73, 47, 23)));
        assertTrue(Arrays.equals(sparseChaineVide, new KnotHash(256).cycle(64, longueursChaineVide)));

        int[] sparseAoC2017 = new int[]{2, 43, 207, 224, 132, 199, 217, 27, 176, 138, 9, 177, 228, 225, 153, 170, 140, 244, 240, 1, 7, 230, 142, 114, 148, 229, 60, 28, 163, 3, 48, 186, 24, 166, 174, 106, 34, 152, 20, 95, 187, 59, 61, 155, 179, 220, 47, 6, 84, 83, 188, 87, 68, 154, 226, 233, 42, 137, 189, 194, 168, 160, 109, 180, 38, 117, 251, 151, 162, 123, 192, 98, 214, 72, 127, 10, 56, 121, 122, 126, 202, 79, 245, 175, 216, 112, 136, 91, 0, 8, 55, 94, 46, 193, 238, 85, 135, 104, 82, 110, 144, 70, 29, 156, 105, 143, 5, 211, 147, 37, 215, 69, 201, 52, 172, 253, 128, 158, 64, 4, 221, 67, 18, 248, 107, 39, 167, 66, 213, 157, 146, 171, 111, 36, 125, 93, 219, 169, 239, 205, 197, 50, 78, 65, 13, 124, 133, 89, 116, 99, 118, 62, 75, 96, 63, 231, 131, 53, 184, 250, 101, 185, 249, 210, 73, 212, 145, 74, 11, 71, 190, 130, 139, 183, 191, 222, 86, 21, 150, 247, 40, 26, 45, 77, 19, 149, 23, 237, 254, 100, 227, 236, 173, 161, 102, 141, 235, 76, 33, 252, 255, 115, 206, 218, 243, 232, 242, 204, 80, 103, 203, 88, 14, 51, 209, 134, 223, 200, 30, 165, 195, 129, 208, 58, 196, 92, 178, 90, 54, 41, 108, 113, 49, 15, 16, 57, 198, 12, 31, 22, 159, 97, 81, 234, 181, 241, 182, 35, 246, 120, 44, 119, 25, 17, 32, 164}; //Resultat récup sur reddit
        List<Integer> longueursAoC2017 = KnotHash.longueursDeChaine("AoC 2017");
        assertTrue(Arrays.equals(sparseAoC2017, new KnotHash(256).cycle(64, longueursAoC2017)));

        /*
        XorBlocs
         */
        assertTrue(Arrays.equals(KnotHash.xorBlocs(1, new int[]{1, 2, 3, 4, 5}),
                new int[]{1, 2, 3, 4, 5}));
        assertTrue(Arrays.equals(KnotHash.xorBlocs(16, new int[]{65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22}),
                new int[]{64}));
        assertTrue(Arrays.equals(KnotHash.xorBlocs(16, new int[]{65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22, 65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22, 65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22, 65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22}),
                new int[]{64, 64, 64, 64}));

        assertTrue(Arrays.equals(KnotHash.xorBlocs(16, new int[]{38, 171, 116, 63, 70, 137, 168, 29, 198, 55, 160, 15, 34, 95, 58, 7}),
                new int[]{162}));
        assertTrue(Arrays.equals(KnotHash.xorBlocs(16, new int[]{188, 189, 238, 141, 30, 31, 124, 241, 20, 1, 244, 203, 234, 73, 236, 211}),
                new int[]{88}));

        int[] xorChaineVide = KnotHash.xorBlocs(16, sparseChaineVide);
        assertTrue(Arrays.equals(xorChaineVide, new int[]{162, 88, 42, 58, 14, 102, 230, 232, 110, 56, 18, 220, 182, 114, 162, 114})); //Resultat calculé à la main pour coller au résultat attendu à l'étape d'après

        /*
        XorBlocsToString
         */
        assertEquals("4007ff", KnotHash.xorBlocsToString(new int[]{64, 7, 255}));
        assertEquals("40404040", KnotHash.xorBlocsToString(new int[]{64, 64, 64, 64}));
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", KnotHash.xorBlocsToString(xorChaineVide)); //Suppose que xorChaineVide est correcte (testée avant)

        /*
        Hash
         */
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", new KnotHash(256).hash(""));
        assertEquals("33efeb34ea91902bb2f59c9920caa6cd", new KnotHash(256).hash("AoC 2017"));
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", new KnotHash(256).hash("1,2,3"));
        assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", new KnotHash(256).hash("1,2,4"));

        System.out.println(new KnotHash(256).hash(Fichier.premiereLigne("day10")));

    }

}
