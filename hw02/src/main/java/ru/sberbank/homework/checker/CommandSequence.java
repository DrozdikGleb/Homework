package ru.sberbank.homework.checker;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandSequence {
    @Getter
    private List<Expression> expressions = new ArrayList<>();

    public static CommandSequence create() {
        return new CommandSequence();
    }

    public CommandSequence add(Expression expression) {
        expressions.add(expression);
        return this;
    }

    public CommandSequence addAllExpressions(Expression[] expressionArray) {
        expressions.addAll(Arrays.asList(expressionArray));
        return this;
    }
}
