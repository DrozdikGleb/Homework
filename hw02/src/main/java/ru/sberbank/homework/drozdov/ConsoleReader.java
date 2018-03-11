package ru.sberbank.homework.drozdov;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner = new Scanner(System.in);
    private ExpressionParser parser = new ExpressionParser();

    public void getLine() {
        String inputExpression = scanner.nextLine();
        switch (inputExpression) {
            case "":
                System.out.println("Вы ввели пустую строку");
                break;
            case "quit":
                System.exit(0);
            default:
                System.out.printf("%s%n", parser.calculate(inputExpression));
                break;
        }
    }
}
