import org.junit.Before;
import org.junit.Test;
import ru.sberbank.homework.drozdov.AmountNotValidException;
import ru.sberbank.homework.drozdov.TerminalImpl;
import ru.sberbank.homework.drozdov.WrongPinException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gleb on 25.03.2018
 */
public class TerminalImplTest {
    private static final String DEFAULT_PASSWORD = "0000";
    private TerminalImpl terminal;

    @Before
    public void setUp() {
        terminal = new TerminalImpl();
    }

    @Test
    public void inputCorrectPin() {
        terminal.checkPin(DEFAULT_PASSWORD);
    }

    @Test
    public void checkBalance() {
        terminal.putMoney(300);
        assertEquals(300, terminal.showBalance());
    }

    @Test
    public void putCorrectAmountOfMoney() {
        terminal.putMoney(200);
        assertEquals(200, terminal.showBalance());
    }

    @Test
    public void withdrawCorrectAmountOfMoney() {
        terminal.putMoney(300);
        terminal.withdrawMoney(200);
        assertEquals(100, terminal.showBalance());
    }

    @Test(expected = WrongPinException.class)
    public void enterWrongPin() {
        terminal.checkPin("1234");
    }

    @Test(expected = AmountNotValidException.class)
    public void putNotValidAmountOfMoney() {
        terminal.putMoney(123);
    }

    @Test(expected = AmountNotValidException.class)
    public void withdrawNotValidAmountOfMoney() {
        terminal.putMoney(300);
        terminal.withdrawMoney(221);
    }
}
