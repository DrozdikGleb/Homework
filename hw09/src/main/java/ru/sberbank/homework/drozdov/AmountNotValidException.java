package ru.sberbank.homework.drozdov;

/**
 * Created by Gleb on 19.02.2018
 */
public class AmountNotValidException extends RuntimeException {
    public AmountNotValidException(String message) {
        super(message);
    }
}
