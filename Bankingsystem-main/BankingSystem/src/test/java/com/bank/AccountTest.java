import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(101, 500.0);
    }

    @Test
    void testDepositValidAmount() {
        assertTrue(account.deposit(200.0));
        assertEquals(700.0, account.getBalance());
    }

    @Test
    void testDepositInvalidAmount() {
        assertFalse(account.deposit(-50.0));
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void testWithdrawValidAmount() {
        assertTrue(account.withdraw(200.0));
        assertEquals(300.0, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertFalse(account.withdraw(600.0));
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void testWithdrawNegativeAmount() {
        assertFalse(account.withdraw(-50.0));
        assertEquals(500.0, account.getBalance());
    }
}