package ru.sberbank.homework.drozdov.hw3_1;

import java.util.Scanner;

/**
 * Created by Gleb on 23.02.2018
 */
public class Interaction {
    private Scanner input = new Scanner(System.in);
    private Terminal terminal = new TerminalImpl();

    public void start() {
        while (true) {
            System.out.println("Введите PIN");
            try {
                boolean pinChecker = false;
                while (!pinChecker) {
                    try {
                        pinChecker = terminal.checkPin(input.nextLine());
                    } catch (AccountIsLockedException | WrongPinException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Введите действие\n" +
                        "1 - положить деньги\n" +
                        "2 - cнять деньги\n" +
                        "3 - проверить баланс\n" +
                        "4 - закончить работу");
                String action = input.nextLine();
                try {
                    switch (action) {
                        case "1":
                            putMoneyInteraction();
                            break;
                        case "2":
                            withdrawMoneyInteraction();
                            break;
                        case "3":
                            System.out.println("Ваш баланс " + String.valueOf(terminal.showBalance()));
                            break;
                        case "4":
                            input.close();
                            System.exit(0);
                        default:
                            System.out.println("Вы ввели неккоректную команду");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введено неккоректное число");
                }
            } catch (AmountNotValidException | NotEnoughMoneyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void putMoneyInteraction() {
        System.out.println("Введите сумму, которую хотите положить");
        long amount = Long.parseLong(input.nextLine());
        terminal.putMoney(amount);
        System.out.println("Вы положили " + String.valueOf(amount));
    }

    private void withdrawMoneyInteraction() {
        System.out.println("Введите сумму, которую хотите снять");
        long amount = Long.parseLong(input.nextLine());
        terminal.withdrawMoney(amount);
        System.out.println("Вы сняли " + String.valueOf(amount));
    }
}
