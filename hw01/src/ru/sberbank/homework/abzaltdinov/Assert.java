package ru.sberbank.homework.abzaltdinov;

public class Assert {

    private static final double EPSILON = 1e-6;

    public static void assertEquals(String message, int expected, int actual) {
        if (expected != actual) {
            throw new AssertException(message);
        } else {
            System.out.println(message + " - test passed!");
        }
    }

    public static void assertEquals(String message, double expected, double actual) {
        if (Math.abs(expected - actual) > EPSILON) {
            throw new AssertException(message);
        } else {
            System.out.println(message + " - test passed!");
        }
    }

    public static void assertEquals(String message, String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertException(message);
        } else {
            System.out.println(message + " - test passed!");
        }
    }
}
