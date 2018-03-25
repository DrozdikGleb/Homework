package ru.sberbank.homework.drozdov;

/**
 * Created by Gleb on 19.02.2018
 */
public class WrongPinException extends RuntimeException {
    public WrongPinException(String message) {
        super(message);
    }
}
