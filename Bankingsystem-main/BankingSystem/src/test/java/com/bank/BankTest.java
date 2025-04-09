import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {
    private Bank bank;
    private Account acc1, acc2;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        acc1 = new Account(101, 500.0);
        acc2 = new Account(102, 300.0);
        bank.addAccount(acc1);
        bank.addAccount(acc2);
    }

    @Test
    void testValidTransfer() {
        assertTrue(bank.transfer(101, 102, 200.0));
        assertEquals(300.0, acc1.getBalance());
        assertEquals(500.0, acc2.getBalance());
    }

    @Test
    void testTransferInsufficientFunds() {
        assertFalse(bank.transfer(101, 102, 600.0));
        assertEquals(500.0, acc1.getBalance());
        assertEquals(300.0, acc2.getBalance());
    }

    @Test
    void testTransferToInvalidAccount() {
        assertFalse(bank.transfer(101, 999, 100.0)); // Non-existent account
    }

    @Test
    void testTransferFromInvalidAccount() {
        assertFalse(bank.transfer(999, 102, 100.0)); // Non-existent account
    }
}