package ru.sberbank.homework.common;

/**
 * Вот такой простой интерфейс
 */
public interface Calculator {

    /**
     * Обрабатывает пользовательский ввод.
     * примеры команд:
     * 0345 * 0b10101
     * / 1.04
     *
     * @param userInput команда пользователя.
     * @return отформатированный результат вычисления
     */
    String calculate(String userInput);

}
