package ru.sberbank.homework.drozdov;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

public class ExpressionChecker {
    private String expression;
    private StringBuilder refactorString;
    private HashMap<Integer, Character> validLiterals = new HashMap<>();
    private HashMap<Integer, Character> operations = new HashMap<>();

    ExpressionChecker(String expression) {
        this.expression = expression;
        fillValidLiterals();
    }

    /**
     * проверяем все ли числа в нашем выражении либо литерал целочисленного типа, либо вещественное число
     */
    public boolean isValid() {
        if (!checkWhitespacesAndBrackets()) {
            return false;
        }
        expression = expression.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ");
        String[] arrayOfLiterals = expression.split("\\s+");
        if (arrayOfLiterals.length == 2) {
            refactorString = new StringBuilder("error > wrong expression");
            return false;
        }
        if (!checkSequenceOfOperations(arrayOfLiterals)) {
            refactorString = new StringBuilder("error > wrong expression");
            return false;
        }
        refactorString = new StringBuilder();
        BigDecimal num;
        for (String arrayOfLiteral : arrayOfLiterals) {
            String currentString = arrayOfLiteral.toLowerCase();
            if (currentString.equals("")) {
                continue;
            }
            if (!checkUnderscoresAndValidLiterals(currentString)) {
                return false;
            }
            if ((currentString.length() == 1) && ((operations.containsValue(currentString.charAt(0))) || (currentString.charAt(0) == '(') || (currentString.charAt(0) == ')'))) {
                refactorString.append(currentString.charAt(0)).append(" ");
                continue;
            }
            try {
                String refactoringCurrentString = currentString.replaceAll("_", "").replaceAll("l", "");
                BigDecimal signDecimal = new BigDecimal("1");
                if (refactoringCurrentString.startsWith("+")) {
                    refactoringCurrentString = refactoringCurrentString.substring(1);
                } else if (refactoringCurrentString.startsWith("-")) {
                    signDecimal = new BigDecimal("-1");
                    refactoringCurrentString = refactoringCurrentString.substring(1);
                }
                if (refactoringCurrentString.startsWith("0x")) {
                    num = new BigDecimal(new BigInteger(refactoringCurrentString.substring(2), 16).longValue()).multiply(signDecimal);
                } else if (refactoringCurrentString.startsWith("0b")) {
                    num = new BigDecimal(new BigInteger(refactoringCurrentString.substring(2), 2).longValue()).multiply(signDecimal);
                } else if ((refactoringCurrentString.startsWith("0")) && (refactoringCurrentString.length() > 1) && (refactoringCurrentString.charAt(1) != '.')) {
                    num = new BigDecimal(new BigInteger(refactoringCurrentString.substring(1), 8).longValue()).multiply(signDecimal);
                } else if (refactoringCurrentString.contains(".")) {
                    num = new BigDecimal(Double.valueOf(refactoringCurrentString)).multiply(signDecimal);
                } else {
                    num = new BigDecimal(new BigInteger(refactoringCurrentString).longValue()).multiply(signDecimal);
                }
            } catch (RuntimeException e) {
                refactorString = new StringBuilder("error > " + currentString);
                return false;
            }
            refactorString.append(String.valueOf(num)).append(" ");
        }
        return true;
    }

    private boolean checkUnderscoresAndValidLiterals(String currentString) {
        boolean checkUnderscoresAndValidLiterals = false;
        for (int i = 0; i < currentString.length(); i++) {
            char curChar = currentString.charAt(i);
            if (curChar == '_') {
                if ((i == 0) || (i == currentString.length() - 1)) {
                    checkUnderscoresAndValidLiterals = true;
                } else {
                    char prevChar = currentString.charAt(i - 1);
                    char nextChar = currentString.charAt(i + 1);
                    if (!(((Character.isDigit(prevChar)) || ((prevChar >= 'a') && (prevChar <= 'f')) || (prevChar == '_')) && ((Character.isDigit(nextChar)) || ((nextChar >= 'a') && (nextChar <= 'f')) || (nextChar == '_')))) {
                        checkUnderscoresAndValidLiterals = true;
                    }
                }
            }
            if ((!validLiterals.containsValue(curChar)) || (currentString.startsWith("0b_"))) {
                checkUnderscoresAndValidLiterals = true;
            }
            if (checkUnderscoresAndValidLiterals) {
                refactorString = new StringBuilder("error > " + currentString);
                return false;
            }
        }
        return true;
    }

    private boolean checkSequenceOfOperations(String[] literals) {
        boolean operation = true;
        for (String current :
                literals) {
            if (current.equals("")) {
                continue;
            }
            if ((current.length() == 1) && ((current.charAt(0) == '(') || (current.charAt(0) == ')'))) {
                continue;
            }
            if ((current.length() == 1) && (operations.containsValue(current.charAt(0)))) {
                if (operation) {
                    return false;
                } else {
                    operation = true;
                    continue;
                }
            }
            if (!operation) {
                return false;
            } else {
                operation = false;
            }
        }
        return true;
    }

    /**
     * проверка на лишние пробелы и правильность расстановки скобок
     */
    private boolean checkWhitespacesAndBrackets() {
        int k = 0;
        int bracketsBalance = 0;
        boolean checker = false;
        for (int i = 0; i < expression.length(); i++) {
            char curChar = expression.charAt(i);
            if (curChar == ' ') {
                k++;
            } else {
                k = 0;
            }
            switch (curChar) {
                case '(':
                    bracketsBalance++;
                    break;
                case ')':
                    bracketsBalance--;
                    break;
            }
            if (bracketsBalance < 0) {
                checker = true;
                break;
            }
            if (k == 2) {
                checker = true;
                break;
            }
        }
        if (bracketsBalance > 0) {
            checker = true;
        }
        if (checker) {
            refactorString = new StringBuilder("error > wrong expression");
            return false;
        } else {
            return true;
        }
    }

    public String getRefactorString() {
        return refactorString.toString();
    }

    private void fillValidLiterals() {
        for (int i = 0; i < 10; i++) {
            validLiterals.put(i, (char) (i + '0'));
        }
        String validLiteralsString = "xXb_Ll .()+-/*abcdfeABCDFE";
        String[] validLiteralsArray = validLiteralsString.split("");
        for (int i = 0; i < validLiteralsArray.length; i++) {
            validLiterals.put(i + 10, validLiteralsArray[i].charAt(0));
        }
        for (int i = 0; i < 4; i++) {
            operations.put(i, validLiteralsArray[i + 10].charAt(0));
        }
    }
}
