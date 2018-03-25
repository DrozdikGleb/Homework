package ru.sberbank.homework.drozdov;

/**
 * Created by Gleb on 19.02.2018
 */
public class TerminalImpl implements Terminal {
    private static final String WRONG_PIN_EXCEPTION = "Для работы с терминалом требуется корректный пин";
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();

    @Override
    public void putMoney(long amount) {
        server.putMoney(amount);
    }

    @Override
    public void withdrawMoney(long amount) {
        server.withdrawMoney(amount);
    }

    @Override
    public void checkPin(String pin) {
        if (!pinValidator.checkPin(pin)) {
            throw new WrongPinException(WRONG_PIN_EXCEPTION);
        }
    }

    @Override
    public long showBalance() {
        return server.getCurrentAmountOfMoney();
    }
}
