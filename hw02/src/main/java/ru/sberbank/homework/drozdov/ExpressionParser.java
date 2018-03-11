package ru.sberbank.homework.drozdov;

import ru.sberbank.homework.common.Calculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ExpressionParser implements Calculator {
    private String currentResult = "";
    private static final String DOUBLE_AND_INTEGER_REGEX = "[-+]?([0-9]*\\.[0-9]+|[0-9]+)";
    private String[] dividingExpression;
    private int index;
    private double number;
    private Operation operation;

    /**
     * Вычисляем значение выражения методом рекурсивного спуска
     *
     * @param userInput команда пользователя.
     * @return ответ типа String
     */
    @Override
    public String calculate(String userInput) {
        char firstChar = userInput.charAt(0);
        if ((firstChar != '+') && (firstChar != '-') && (firstChar != '/') && (firstChar != '*')) {
            currentResult = "";
        } else if (userInput.charAt(1) != ' ') {
            currentResult = "";
        } else if (currentResult.equals("")) {
            return "error > wrong expression";
        }
        String currentExpression = currentResult + " " + userInput;
        index = 0;
        ExpressionChecker checker = new ExpressionChecker(currentExpression);
        if (checker.isValid()) {
            currentExpression = checker.getRefactorString();
            dividingExpression = currentExpression.split("\\s");
            Expression ans = sum();
            currentResult = String.valueOf(ans.evaluate());
            return getCorrectString(currentResult);
        } else {
            currentResult = "";
            return checker.getRefactorString();
        }
    }

    private String getCorrectString(String answer) {
        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return String.valueOf(decimalFormat.format(Double.parseDouble(answer)));
    }

    private void getNext() {
        if (index == dividingExpression.length) {
            return;
        }
        if (dividingExpression[index].matches(DOUBLE_AND_INTEGER_REGEX)) {
            number = Double.parseDouble(dividingExpression[index]);
            index++;
            operation = Operation.NUMBER;
        } else {
            char character = dividingExpression[index].charAt(0);
            switch (character) {
                case '+':
                    operation = Operation.ADDITION;
                    break;
                case '-':
                    operation = Operation.SUBTRACTION;
                    break;
                case '*':
                    operation = Operation.MULTIPLICATION;
                    break;
                case '/':
                    operation = Operation.DIVISION;
                    break;
                case '(':
                    operation = Operation.BRACKET;
                    break;
            }
            index++;
        }
    }

    private Expression end() {
        getNext();
        Expression result;
        switch (operation) {
            case NUMBER:
                result = new Number(number);
                getNext();
                break;
            case BRACKET:
                result = sum();
                getNext();
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    private Expression multiply() {
        Expression left = end();
        while (true) {
            switch (operation) {
                case MULTIPLICATION:
                    left = new Multiplication(left, end());
                    break;
                case DIVISION:
                    left = new Division(left, end());
                    break;
                default:
                    return left;
            }
        }
    }

    private Expression sum() {
        Expression left = multiply();
        while (true) {
            switch (operation) {
                case SUBTRACTION:
                    left = new Subtraction(left, multiply());
                    break;
                case ADDITION:
                    left = new Addition(left, multiply());
                    break;
                default:
                    return left;
            }
        }
    }
}