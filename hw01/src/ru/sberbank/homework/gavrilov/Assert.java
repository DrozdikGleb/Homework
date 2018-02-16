package ru.sberbank.homework.gavrilov;

public class Assert {

    /**
     * The constant for comparing real numbers.
     */
    private static double DELTA = 0.00001;

    public static void assertEquals(String msg, int expected, int actual) {
        if (expected != actual) {
            throw new AssertException(msg + " - Test failed!");
        } else {
            System.out.println(msg + " - Test passed!");
        }
    }

    public static void assertEquals(String msg, double expected, double actual) {
        if (Math.abs(expected - actual) > DELTA) {
            throw new AssertException(msg + " - Test failed!");
        } else {
            System.out.println(msg + " - Test passed!");
        }
    }

    public static void assertEquals(String msg, String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertException(msg + " - Test failed!");
        } else {
            System.out.println(msg + " - Test passed!");
        }
    }
}