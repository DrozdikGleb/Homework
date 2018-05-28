package ru.sberbank.homework.drozdov.hw3_1;

/**
 * Created by Gleb on 19.02.2018
 */
public class TerminalServer {
    private long currentAmountOfMoney = 0;

    public void putMoney(long amount) {
        checkCorrectAmount(amount);
        currentAmountOfMoney += amount;
    }

    public void withdrawMoney(long amount) {
        checkCorrectAmount(amount);
        if (currentAmountOfMoney < amount) {
            throw new NotEnoughMoneyException("Не достаточно средств на вашем счету");
        } else {
            currentAmountOfMoney -= amount;
        }
    }

    public void checkCorrectAmount(long amount) {
        if ((amount <= 0) || (amount % 100 != 0)) {
            throw new AmountNotValidException("Сумма должна быть кратна 100");
        }
    }

    public long getCurrentAmountOfMoney() {
        return currentAmountOfMoney;
    }
}
