package Tests;

import junit.framework.TestCase;

import static Main.AlgoWithString.getStringPosFromSequence;

/**
 * Created by Андрей on 19.09.2014.
 */
public class Tests extends TestCase {
    public static void testFirstsStrings() {
        assertTrue("первые 10 чисел: завален", getStringPosFromSequence("12345678910") == 1);
    }

    public static void testFromTask1() {
        assertTrue("6789: завален", getStringPosFromSequence("6789") == 6);
    }

    public static void testFromTask2() {
        assertTrue("111: завален", getStringPosFromSequence("111") == 12);
    }

    public static void testLeftBoundary() {
        assertTrue("1: завален", getStringPosFromSequence("1") == 1);
    }

    public static void testRightBoundary() {
        assertFalse("1: завален", getStringPosFromSequence("671") == 1);
    }
}
