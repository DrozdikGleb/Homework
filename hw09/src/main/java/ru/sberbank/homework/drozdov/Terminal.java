package ru.sberbank.homework.drozdov;

public interface Terminal {
    void putMoney(long amount);

    void withdrawMoney(long amount);

    void checkPin(String pin);

    long showBalance();
}
