package ru.sberbank.homework.gavrilov;

public class SimpleCalculator {

    /**
     * Returns the sum of its arguments.
     *
     * @param first  the first value.
     * @param second the second value.
     * @return the result.
     */
    public static int add(int first, int second) {
        return first + second;
    }

    /**
     * Returns the sum of its arguments.
     *
     * @param first  the first value.
     * @param second the second value.
     * @return the result.
     */
    public static double add(double first, double second) {
        return first + second;
    }

    /**
     * Returns the difference of the arguments.
     *
     * @param first  the first value.
     * @param second the second value to subtract from the first.
     * @return the result.
     */
    public static int subtract(int first, int second) {
        return first - second;
    }

    /**
     * Returns the difference of the arguments.
     *
     * @param first  the first value.
     * @param second the second value to subtract from the first.
     * @return the result.
     */
    public static double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Returns the product of the arguments.
     *
     * @param first  the first value.
     * @param second the second value.
     * @return the result.
     */
    public static int multiply(int first, int second) {
        return first * second;
    }

    /**
     * Returns the product of the arguments.
     *
     * @param first  the first value.
     * @param second the second value.
     * @return the result.
     */
    public static double multiply(double first, double second) {
        return first * second;
    }

    /**
     * Returns the quotient of the arguments.
     *
     * @param first  the first value - the dividend.
     * @param second the first value - the divisor.
     * @return the result.
     */
    public static int divide(int first, int second) {
        if (second == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return first / second;
    }

    /**
     * Returns the quotient of the arguments.
     *
     * @param first  the first value - the dividend.
     * @param second the first value - the divisor.
     * @return the result.
     */
    public static double divide(double first, double second) {
        if (second == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return first / second;
    }

}