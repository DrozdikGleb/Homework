package ru.sberbank.homework.gavrilov;

public class MainClass {

    public static void main(String[] args) {
        allTest();
    }

    private static void allTest() {
        SimpleCalculatorTest calculatorTest = new SimpleCalculatorTest();
        calculatorTest.testIntAdd();
        calculatorTest.testDoubleAdd();
        calculatorTest.testIntSubtract();
        calculatorTest.testDoubleSubtract();
        calculatorTest.testIntMultiply();
        calculatorTest.testDoubleMultiply();
        calculatorTest.testIntDiv();
        calculatorTest.testDoubleDiv();
        calculatorTest.testIntDivToDivideByZero();
        calculatorTest.testDoubleDivToDivideByZero();
    }
}
