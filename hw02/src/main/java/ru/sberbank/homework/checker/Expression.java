package ru.sberbank.homework.checker;

import lombok.*;

@Getter
@RequiredArgsConstructor // Почему-то его недостаточно
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@ToString
public class Expression {
    private final String input;
    private final String expectedOutput;
    private boolean isFailed;

    public Expression fail() {
        isFailed = true;
        return this;
    }
}
