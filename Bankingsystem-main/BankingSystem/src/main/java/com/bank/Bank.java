import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public boolean transfer(int fromAcc, int toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender != null && receiver != null && sender.withdraw(amount)) {
            receiver.deposit(amount);
            return true;
        }
        return false; // Transfer failed due to invalid accounts or insufficient funds
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}