package ru.sberbank.homework.abzaltdinov;

/**
 * Simple calculator with +,-,*,/ operation with int and double
 */
public class SimpleCalculator {
    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        if (second == 0) {
            throw new DivisionByZeroException();
        }
        return first / second;
    }

    public double add(double first, double second) {
        return first + second;
    }

    public double subtract(double first, double second) {
        return first - second;
    }

    public double multiply(double first, double second) {
        return first * second;
    }

    public double divide(double first, double second) {
        if (second == 0) {
            throw new DivisionByZeroException();
        }
        return first / second;
    }
}
