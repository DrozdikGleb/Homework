package ru.sberbank.homework.gavrilov;

public class SimpleCalculatorTest {

    public void testIntAdd() {
        int actual = SimpleCalculator.add(2, 2);
        int expected = 4;
        Assert.assertEquals("2 + 2 is 4", expected, actual);
    }

    public void testDoubleAdd() {
        double actual = SimpleCalculator.add(10.25, -5.25);
        double expected = 5.0;
        Assert.assertEquals("10.25 + (-5.25) is " + expected, expected, actual);
    }

    public void testIntSubtract() {
        int actual = SimpleCalculator.subtract(154, -88);
        int expected = 242;
        Assert.assertEquals("154 - (-88) is 242", expected, actual);
    }

    public void testDoubleSubtract() {
        double actual = SimpleCalculator.subtract(-64.8, 34.3);
        double expected = -99.1;
        Assert.assertEquals("-64.8 - 34.3 is " + expected, expected, actual);
    }

    public void testIntMultiply() {
        int actual = SimpleCalculator.multiply(7, -8);
        int expected = -56;
        Assert.assertEquals("7 * -8 is " + expected, expected, actual);
    }

    public void testDoubleMultiply() {
        double actual = SimpleCalculator.multiply(99.5, 1.5);
        double expected = 149.25;
        Assert.assertEquals("99.5 * 1.5 is " + expected, expected, actual);
    }

    public void testIntDiv() {
        int actual = SimpleCalculator.divide(88, -7);
        int expected = -12;
        Assert.assertEquals("88 / -7 is " + expected, expected, actual);
    }

    public void testDoubleDiv() {
        double actual = SimpleCalculator.divide(45.6, 1.36);
        double expected = 33.52941;
        Assert.assertEquals("45.6 / 1.36 is " + expected, expected, actual);
    }

    public void testIntDivToDivideByZero() {
        String expected = "Divide by zero!";
        try {
            SimpleCalculator.divide(45, 0);
            throw new AssertException("45 / 0 is \"" + expected + "\"" + " - Test failed!");
        } catch (ArithmeticException ae) {
            Assert.assertEquals("45 / 0 is \"" + expected + "\"", expected, ae.getMessage());
        }
    }

    public void testDoubleDivToDivideByZero() {
        String expected = "Divide by zero!";
        try {
            SimpleCalculator.divide(75.6, 0.0);
            throw new AssertException("\"75.6 / 0.0 is \\\"\" + expected + \"\\\"\" + \" - Test failed!\"");
        } catch (ArithmeticException ae) {
            Assert.assertEquals("75.6 / 0.0 is \"" + expected + "\"", expected, ae.getMessage());
        }
    }
}