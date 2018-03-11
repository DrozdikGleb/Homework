package ru.sberbank.homework.drozdov;

/**
 * Created by Gleb on 14.02.2018
 */
public class Multiplication extends Operations {
    Multiplication(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    protected double calculate(double first, double second) {
        return first * second;
    }
}
