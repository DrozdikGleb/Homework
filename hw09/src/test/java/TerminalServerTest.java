import org.junit.Before;
import org.junit.Test;
import ru.sberbank.homework.drozdov.AmountNotValidException;
import ru.sberbank.homework.drozdov.NotEnoughMoneyException;
import ru.sberbank.homework.drozdov.TerminalServer;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gleb on 26.03.2018
 */
public class TerminalServerTest {
    private TerminalServer terminalServer;

    @Before
    public void setUp() {
        terminalServer = new TerminalServer();
    }

    @Test
    public void putCorrectSum() {
        terminalServer.putMoney(100);
        assertEquals(100, terminalServer.getCurrentAmountOfMoney());
    }

    @Test
    public void withdrawCorrectAmountOfMoney() {
        terminalServer.putMoney(200);
        terminalServer.withdrawMoney(100);
        assertEquals(100, terminalServer.getCurrentAmountOfMoney());
    }

    @Test
    public void checkBalance() {
        terminalServer.putMoney(500);
        assertEquals(500, terminalServer.getCurrentAmountOfMoney());
    }

    @Test(expected = AmountNotValidException.class)
    public void putNovValidAmount() {
        terminalServer.putMoney(134);
    }

    @Test(expected = AmountNotValidException.class)
    public void withdrawNotValidAmount() {
        terminalServer.withdrawMoney(121);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void withdrawTooMuchMoney() {
        terminalServer.withdrawMoney(100);
    }

}
