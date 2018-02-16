import test.SimpleCalculatorTest;

public class MainCalculator {
    public static void main(String[] args) {
        SimpleCalculatorTest test = new SimpleCalculatorTest();

        //The tests pass
        test.additionTest(2, 2, 4);
        test.additionTest(2.3456, 2.6543, 4.9999);
        test.subtractionTest(5, 2, 3);
        test.subtractionTest(3.3333, 1.1111, 2.2222);
        test.multiplicationTest(3, 3, 9);
        test.multiplicationTest(3.3, 2.2, 7.26);
        test.divisionTest(15, 3, 5);
        test.divisionTest(5.0625, 2.25, 2.25);

        /* The tests fail

        test.additionTest(2, 2, 3);
        test.additionTest(2.3456, 2.6543, 4.9998);
        test.subtractionTest(5, 2, 4);
        test.subtractionTest(3.3333, 1.1111, 2.2225);
        test.multiplicationTest(3, 3, 9);
        test.multiplicationTest(3.3, 2.2, 7.28);
        test.divisionTest(15, 3, 5);
        test.divisionTest(5.0625,2.25 , 2.20);
        */
    }
}
