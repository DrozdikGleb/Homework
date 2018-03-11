package ru.sberbank.homework.drozdov;

/**
 * Created by Gleb on 14.02.2018
 */
public abstract class Operations implements Expression {
    private Expression first;
    private Expression second;
    Operations(Expression first, Expression second){
        this.first = first;
        this.second = second;
    }
    protected abstract double calculate(double first, double second);

    @Override
    public double evaluate() {
        return calculate(first.evaluate(),second.evaluate());
    }
}
