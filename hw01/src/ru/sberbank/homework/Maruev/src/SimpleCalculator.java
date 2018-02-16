/**
 * Created by Иван on 07.02.2018.
 */
public class SimpleCalculator {

    public int sum(int one, int two) {
        return one + two;
    }

    public double sum(double one, double two) {
        return one + two;
    }

    public int substract(int one, int two) {
        return one - two;
    }

    public double substract(double one, double two) {
        return one - two;
    }

    public int multiply(int one, int two) {
        return one * two;
    }

    public double multiply(double one, double two) {
        return one * two;
    }

    public int division(int one, int two) {
        if (two == 0) {
            throw new AssertExpectedError("Exception zero");
        }
        return one / two;
    }

    public double division(double one, double two) {
        if (two == 0) {
            throw new AssertExpectedError("Exception zero");
        }
        return one / two;
    }
}
