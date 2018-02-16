package ru.sberbank.homework.abzaltdinov;

public class MainClass {
    public static void main(String[] args) {
        runAllTests();
    }

    public static void runAllTests() {
        SimpleCalculatorTest calculatorTest = new SimpleCalculatorTest();

        calculatorTest.intAdditionTest();
        calculatorTest.intSubstractionTest();
        calculatorTest.intMultiplicationTest();
        calculatorTest.intDivisionTest();
        calculatorTest.intDivisionByZeroTest();

        calculatorTest.doubleAdditionTest();
        calculatorTest.doubleSubstractionTest();
        calculatorTest.doubleMultiplicationTest();
        calculatorTest.doubleDivisionTest();
        calculatorTest.doubleDivisionByZeroTest();
    }
}
