package ru.sberbank.homework.dergun

public class SimpleCalculatorTest {
    public static void startAllTest() throws FailedTestExeption {
        additionInt();
        subtractionInt();
        divisionInt();
        multyplyngInt();
        additionDouble();
        subtractionDouble();
        divisionDouble();
        multyplyngDouble();
    }

    private static void additionInt() throws FailedTestExeption {
        Assert.assertEquals("int: 2 + 2 != 4", 4, SimpleCalculator.addition(2, 2));
        Assert.assertEquals("int: 0 + 0 != 0", 0, SimpleCalculator.addition(0, 0));
        Assert.assertEquals("int: 0 + 2^31 -1 != 4", Math.pow(2, 31) - 1, SimpleCalculator.addition(0, Math.pow(2, 31) - 1));
        Assert.assertEquals("int: -2^31 + 2^31 != 0", 0, SimpleCalculator.addition(-Math.pow(2, 31), Math.pow(2, 31)));
    }

    private static void subtractionInt() throws FailedTestExeption {
        Assert.assertEquals("int: 2 - 2 != 0", 0, SimpleCalculator.subtraction(2, 2));
        Assert.assertEquals("int: 0 - 2 != 0", -2, SimpleCalculator.subtraction(0, 2));
        Assert.assertEquals("int: 0 - 0 != 0", 0, SimpleCalculator.subtraction(0, 0));
        Assert.assertEquals("int: 2^32 - 2^32 != 0", 0, SimpleCalculator.subtraction(Math.pow(2, 32), Math.pow(2, 32)));
    }

    private static void divisionInt() throws FailedTestExeption {
        Assert.assertEquals("int: 2 / 2 != 1", 1, SimpleCalculator.division(2, 2));
        Assert.assertEquals("int: 0 / 2 != 0", 0, SimpleCalculator.division(0, 2));
        Assert.assertEquals("int: 2^32 / 2^32 != 1", 1, SimpleCalculator.division(Math.pow(2, 32), Math.pow(2, 32)));
        Assert.assertEquals("int: 2 / 3 != 0", 0, SimpleCalculator.division(2, 3));
    }

    private static void multyplyngInt() throws FailedTestExeption {
        Assert.assertEquals("int: 2 * 2 != 4", 4, SimpleCalculator.multyplyng(2, 2));
        Assert.assertEquals("int: 2 * 0 != 0", 0, SimpleCalculator.multyplyng(2, 0));
        Assert.assertEquals("int: 0 * 0 != 0", 0, SimpleCalculator.multyplyng(0, 0));
        Assert.assertEquals("int: 2 * 2^30 != 4", Math.pow(2, 31), SimpleCalculator.multyplyng(2, Math.pow(2, 30)));
    }

    private static void additionDouble() throws FailedTestExeption {
        Assert.assertEquals("doudble: 2.1 + 1.9 != 4", 4, SimpleCalculator.addition(2.1, 1.9));
        Assert.assertEquals("double: 9e-10 + 1e-10 != 1e-9", 1e-9, SimpleCalculator.addition(9e-10, 1e-10));
        Assert.assertEquals("doudble: -10e-10 + 10e-10 != 0", 0.0, SimpleCalculator.addition(-10e-10, 10e-10));
        Assert.assertEquals("doudble: 0.000099999937 + 0.10000000302 != 0", 0.100100002957, SimpleCalculator.addition(0.000099999937, 0.10000000302));
    }

    private static void subtractionDouble() throws FailedTestExeption {
        Assert.assertEquals("double: 2,0000000001 - 2,00000000001 != 9e-10", 9e-10, SimpleCalculator.subtraction(2.000000001, 2.0000000001));
        Assert.assertEquals("double: -123e-10 - (-113e-10) != -1e-11 ", -1e-9, SimpleCalculator.subtraction(-123e-10, -113e-10));
        Assert.assertEquals("double: 6.060606060606061e+14 - (-113e-10) != 6.060606060606061E14 ", 6.060606060606061E14, SimpleCalculator.subtraction(6.060606060606061e+14, -113e-10));
        Assert.assertEquals("double: 12.666245e+13 - 12.006245e13) != -1e-11 ", 66e+11, SimpleCalculator.subtraction(12.666245e+13, 12.006245e13));
    }

    private static void divisionDouble() throws FailedTestExeption {
        Assert.assertEquals("double: 1e-10 / 1e-11 != 10", 10, SimpleCalculator.division(1e-10, 1e-11));
        Assert.assertEquals("double: 123e-10 / 121e-11 != 10.1652892561983471", 10.1652892561983471, SimpleCalculator.division(123e-10, 121e-11));
        Assert.assertEquals("double: 2.2 / 3.3 != 0.66666666666666", 0.66666666666666, SimpleCalculator.division(2.2, 3.3));
        Assert.assertEquals("double: 2e+15 / 3.3 != 6.060606060606061e+14", 6.060606060606061e+14, SimpleCalculator.division(2e+15, 3.3));
    }

    private static void multyplyngDouble() throws FailedTestExeption {
        Assert.assertEquals("double: 10.0 * 1e-11 != 1e-10", 1e-10, SimpleCalculator.multyplyng(10.0, 1e-11));
        Assert.assertEquals("double: 10.1652892561983 * 121e-11 != 123e-10", 123e-10, SimpleCalculator.multyplyng(10.1652892561983, 121e-11));
        Assert.assertEquals("double: 0.66666666666666 * 3.3 != 2.2", 2.1999999999999978, SimpleCalculator.multyplyng(0.66666666666666, 3.3));
        Assert.assertEquals("double: 6.060606060606061e+14 * 2e+15 != 2e+15", 2e+15, SimpleCalculator.multyplyng(6.060606060606061e+14, 3.3));
    }
}

class Assert {
    private static final double DBL_EPSILON = 2.22e-14;

    static void assertEquals(String message, int expected, int actual) {
        if (expected != actual) {
            throw new FailedTestExeption(message);
        } else {
            System.out.println("OK");
        }
    }

    static void assertEquals(String message, double expected, double actual) {
        if (Math.abs(expected - actual) >= DBL_EPSILON) {
            throw new FailedTestExeption(message);
        } else {
            System.out.println("OK");
        }
    }
}

class FailedTestExeption extends RuntimeException {
    public FailedTestExeption(String message) {
        super(message);
    }
}