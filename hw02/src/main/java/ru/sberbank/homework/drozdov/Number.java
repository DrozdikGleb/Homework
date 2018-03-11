package ru.sberbank.homework.drozdov;

/**
 * Created by Gleb on 14.02.2018
 */
public class Number implements Expression {
    private final double value;

    Number(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }
}
