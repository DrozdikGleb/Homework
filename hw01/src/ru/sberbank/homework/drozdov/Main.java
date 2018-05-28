package ru.sberbank.homework.drozdov;

import ru.sberbank.homework.drozdov.tests.SimpleCalculatorTest;

public class Main {
    public static void main(String[] args) {
        SimpleCalculatorTest simpleCalculatorTest = new SimpleCalculatorTest();
        simpleCalculatorTest.sumTest(5, 6, 11);
        simpleCalculatorTest.sumTest(5.4, 9.7, 15.1);
        simpleCalculatorTest.subtractTest(12, 5, 7);
        simpleCalculatorTest.subtractTest(12.0, 7.5, 4.5);
        simpleCalculatorTest.multiplyTest(4, 5, 20);
        simpleCalculatorTest.multiplyTest(4.0, 7.0, 28.0);
        simpleCalculatorTest.divideTest(542, 2, 271);
        simpleCalculatorTest.divideTest(25.4, 2.1, 12.095238);
        simpleCalculatorTest.divideTest(25.4, 0.0, Double.POSITIVE_INFINITY);
        simpleCalculatorTest.divideTest(0.0, 0.0, Double.NaN);
    }
}