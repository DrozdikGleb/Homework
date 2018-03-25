package ru.sberbank.homework.drozdov;

/**
 * Created by Gleb on 19.02.2018
 */
public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException(String message) {
        super(message);
    }
}
