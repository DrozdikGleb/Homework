package ru.sberbank.homework.drozdov.hw3_1;

/**
 * Created by Gleb on 19.02.2018
 */
public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    private static final String WRONG_PIN_EXCEPTION = "Для работы с терминалом введите корректный пин";

    TerminalImpl() {
        server = new TerminalServer();
        pinValidator = new PinValidator();
    }

    @Override
    public void putMoney(long amount) {
        server.putMoney(amount);
    }

    @Override
    public void withdrawMoney(long amount) {
        server.withdrawMoney(amount);
    }

    @Override
    public boolean checkPin(String pin) {
        if (!pinValidator.checkPin(pin)) {
            throw new WrongPinException(WRONG_PIN_EXCEPTION);
        } else {
            return true;
        }
    }

    @Override
    public long showBalance() {
        return server.getCurrentAmountOfMoney();
    }
}
