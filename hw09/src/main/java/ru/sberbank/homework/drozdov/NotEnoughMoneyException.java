package ru.sberbank.homework.drozdov;

/**
 * Created by Gleb on 19.02.2018
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
