package ru.sberbank.homework.abzaltdinov;

public class DivisionByZeroException extends RuntimeException {
    DivisionByZeroException() {
        super("Divided by zero!");
    }
}