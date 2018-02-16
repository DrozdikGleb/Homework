package ru.sberbank.homework.checker;

import lombok.extern.slf4j.Slf4j;
import ru.sberbank.homework.common.Calculator;

@Slf4j
public class SolutionChecker {

    private final CommandSequence[] sequences = {
            cs(ex("2 + 2", "4"), ex("- 1", "3"),  ex("* 2", "6"),  ex("/ 4", "1.5"),  ex("1 - 1", "0")), //happy path all operations
            cs(ex("1+1", "error > wrong expression"), ex("1 - foo", "error > foo")) // неаккуратный пользователь.
            // Остальные тесты пишите сами, своими не поделюсь ;)
    };

    public void startTesting(Calculator calculator) {
        for (CommandSequence cs : sequences) {
            cs.getExpressions().forEach(expression -> calculateAndCheck(calculator, expression));
        }
    }

    private void calculateAndCheck(Calculator calculator, Expression expression) {
        log.debug("executing {} ", expression.getInput());
        String result = calculator.calculate(expression.getInput());
        if (expression.getExpectedOutput().equalsIgnoreCase(result)) {
            log.debug("OK: {} ", result);
        } else {
            log.error("FAIL: {}; expecting: {}", result, expression.getExpectedOutput());
        }
    }

    private CommandSequence cs(Expression... expressions) {
        return CommandSequence.create().addAllExpressions(expressions);
    }

    private Expression ex(String input, String expectedResult) {
        return new Expression(input, expectedResult);
    }
}
