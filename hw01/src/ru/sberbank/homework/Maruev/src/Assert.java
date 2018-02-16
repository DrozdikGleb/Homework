

/**
 * Created by Иван on 07.02.2018.
 */
public class Assert {
    private static final String RESULT_MESSAGE = "Expected result is: ";
    private static final String EQUAL_EX = "Invalid result. ";
    private static final String ZERO_EX = "Division by zero. ";
    private static final double ROUND_VALUE = 0.000001;

    public static void assertIntEquals(String message, int expected, int actual) {
        if (expected != actual) {
            throw new AssertExpectedError(EQUAL_EX + RESULT_MESSAGE + message);
        }
    }

    public static void assertDoubleEquals(String message, double expected, double actual) {
        if (Math.abs(expected - actual) > ROUND_VALUE) {
            throw new AssertExpectedError(EQUAL_EX + RESULT_MESSAGE + message);
        }
    }

    public static String getZeroEx() {
        return ZERO_EX;
    }

}
