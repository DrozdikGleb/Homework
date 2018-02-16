package util;

import exception.TestFailedException;

public class Assert {

    public static void assertEqual(String message, int expected, int actual) {
        if (actual == expected) {
            System.out.println(message);
        } else {
            throw new TestFailedException(actual + " not equal " + expected);
        }
    }

    public static void assertEqual(String message, double expected, double actual) {
        if (actual == expected) {
            System.out.println(message);
        } else {
            throw new TestFailedException(actual + " not equal " + expected);
        }
    }
}
