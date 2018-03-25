import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.sberbank.homework.drozdov.AccountIsLockedException;
import ru.sberbank.homework.drozdov.PinValidator;

/**
 * Created by Gleb on 25.03.2018
 */
public class PinValidatorTest {
    private static final String DEFAULT_PASSWORD = "0000";
    private static final String INCORRECT_PASSWORD = "1234";
    private PinValidator pinValidator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        pinValidator = new PinValidator();
    }

    @Test
    public void checkCorrectPin() {
        pinValidator.checkPin(DEFAULT_PASSWORD);
    }

    @Test(expected = AccountIsLockedException.class)
    public void blockAccount() {
        makeFourAttemptsTypingPassword();
    }

    @Test
    public void checkBlockingMessage() {
        expectedException.expect(AccountIsLockedException.class);
        expectedException.expectMessage("Аккаунт заблокирован на 5 секунд");
        makeFourAttemptsTypingPassword();
    }

    private void makeFourAttemptsTypingPassword() {
        pinValidator.checkPin(INCORRECT_PASSWORD);
        pinValidator.checkPin(INCORRECT_PASSWORD);
        pinValidator.checkPin(INCORRECT_PASSWORD);
        pinValidator.checkPin(INCORRECT_PASSWORD);
    }
}
