/**
 * Created by Иван on 07.02.2018.
 */
public class SimpleCalculatorTest {

    SimpleCalculator calculator = new SimpleCalculator();

    public static void main(String[] args) throws ArithmeticException {

        SimpleCalculatorTest test = new SimpleCalculatorTest();

        test.intSumTest();
        test.intSubTest();
        test.intMultTest();
        test.intDivTest();
        test.intDivZeroTest();

        test.doubleSumTest();
        test.doubleSubTest();
        test.doubleMultTest();
        test.doubleDivTest();
        test.doubleDivZeroTest();

        System.out.println("Good test");
    }

    private void intSumTest() {
        Assert.assertIntEquals("2+2=4", 4, calculator.sum(2, 2));
    }

    private void intSubTest() {
        Assert.assertIntEquals("2-2=0", 0, calculator.substract(2, 2));
    }

    private void intMultTest() {
        Assert.assertIntEquals("3*3=9", 9, calculator.multiply(3, 3));
    }

    private void intDivTest() {
        Assert.assertIntEquals("3/3=9", 1, calculator.division(3, 3));
    }

    private void intDivZeroTest() {

        String expectedMessage = "Exception zero";

        try {
            calculator.division(1, 0);
        } catch (AssertExpectedError e) {
            if (!e.getMessage().equals(expectedMessage)) {
                throw new AssertExpectedError(Assert.getZeroEx());
            }
        }
    }

    private void doubleSumTest() {
        Assert.assertDoubleEquals("2.1+2.2", 4.3, calculator.sum(2.1, 2.2));
    }

    private void doubleSubTest() {
        Assert.assertDoubleEquals("3.1-0.1", 3.0, calculator.substract(3.1, 0.1));
    }

    private void doubleMultTest() {
        Assert.assertDoubleEquals("1.5*1.5", 2.25, calculator.multiply(1.5, 1.5));
    }

    private void doubleDivTest() {
        Assert.assertDoubleEquals("1.5/1.5", 1, calculator.division(1.5, 1.5));
    }

    private void doubleDivZeroTest() {

        String expectedMessage = "Exception zero";

        try {
            calculator.division(1.1, 0);
        } catch (AssertExpectedError e) {
            if (!e.getMessage().equals(expectedMessage)) {
                throw new AssertExpectedError("/by zero");
            }
        }
    }


}
