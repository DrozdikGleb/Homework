package ru.sberbank.homework.drozdov.hw3_1;

/**
 * Created by Gleb on 19.02.2018
 */
public class WrongPinException extends RuntimeException {
    public WrongPinException(String message) {
        super(message);
    }
}
