package ru.sberbank.homework.drozdov.tests;

public class Assert {
    private static final double EPSILON = 1e-5;

    public static void assertEquals(String message, int current, int expected) {
        if (current != expected) {
            throw new RuntimeException("Current value: " + current + "!= " + "expected value: " + expected);
        } else {
            System.out.println(message);
        }
    }

    public static void assertEquals(String message, double current, double expected) {
        if (Math.abs(current - expected) > EPSILON) {
            throw new RuntimeException("Current value: " + current + "!= " + "expected value: " + expected);
        } else {
            System.out.println(message);
        }
    }
}