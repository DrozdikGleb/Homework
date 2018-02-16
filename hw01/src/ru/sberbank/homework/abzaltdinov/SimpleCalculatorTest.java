package ru.sberbank.homework.abzaltdinov;

public class SimpleCalculatorTest {

    SimpleCalculator calculator = new SimpleCalculator();

    public void intAdditionTest() {
        int first = 32;
        int second = -12;
        int expected = 20;
        Assert.assertEquals(first + " + " + second + " is " + expected,
                expected,
                calculator.add(first, second));
    }

    public void doubleAdditionTest() {
        double first = 12.36;
        double second = -33.6;
        double expected = -21.24;
        Assert.assertEquals(first + " + " + second + " is " + expected,
                expected,
                calculator.add(first, second));
    }

    public void intSubstractionTest() {
        int first = 32;
        int second = -12;
        int expected = 44;
        Assert.assertEquals(first + " - " + second + " is " + expected,
                expected,
                calculator.subtract(first, second));
    }

    public void doubleSubstractionTest() {
        double first = 12.36;
        double second = -33.6;
        double expected = 45.96;
        Assert.assertEquals(first + " - " + second + " is " + expected,
                expected,
                calculator.subtract(first, second));
    }

    public void intMultiplicationTest() {
        int first = 32;
        int second = -12;
        int expected = -384;
        Assert.assertEquals(first + " * " + second + " is " + expected,
                expected,
                calculator.multiply(first, second));
    }

    public void doubleMultiplicationTest() {
        double first = 12.36;
        double second = -33.6;
        double expected = -415.296;
        Assert.assertEquals(first + " * " + second + " is " + expected,
                expected,
                calculator.multiply(first, second));
    }

    public void intDivisionTest() {
        int first = 32;
        int second = -12;
        int expected = -2;
        Assert.assertEquals(first + " / " + second + " is " + expected,
                expected,
                calculator.divide(first, second));
    }

    public void doubleDivisionTest() {
        double first = 12.36;
        double second = -1.5;
        double expected = -8.24;
        Assert.assertEquals(first + " / " + second + " is " + expected,
                expected,
                calculator.divide(first, second));
    }

    public void intDivisionByZeroTest() {
        int first = 32;
        int second = 0;
        String expected = "Divided by zero!";
        try {
            calculator.divide(first, second);
            //if uncatched
            throw new AssertException("Uncatched " + DivisionByZeroException.class.getSimpleName() + " in intDivisionByZeroTest");
        } catch (DivisionByZeroException ex) {
            Assert.assertEquals("Handled " + DivisionByZeroException.class.getSimpleName() + " in intDivisionByZeroTest",
                    expected,
                    ex.getMessage());
        }
    }

    public void doubleDivisionByZeroTest() {
        double first = 12.36;
        double second = 0.0;
        String expected = "Divided by zero!";
        try {
            calculator.divide(first, second);
            //if uncatched
            throw new AssertException("Uncatched " + DivisionByZeroException.class.getSimpleName() + " in doubleDivisionByZeroTest");
        } catch (DivisionByZeroException ex) {
            Assert.assertEquals("Handled " + DivisionByZeroException.class.getSimpleName() + " in doubleDivisionByZeroTest",
                    expected,
                    ex.getMessage());
        }
    }
}
