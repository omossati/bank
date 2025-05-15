
import org.example.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void deposit_shouldIncreaseBalanceAndRecordTransaction() {
        account.deposit(500);
        assertEquals(500, account.getBalance());

        List<Transaction> txs = account.getTransactions();
        assertEquals(1, txs.size());
        assertEquals(500, txs.get(0).getAmount());
    }

    @Test
    void withdraw_shouldDecreaseBalanceAndRecordTransaction() {
        account.deposit(1000);
        account.withdraw(300);

        assertEquals(700, account.getBalance());

        List<Transaction> txs = account.getTransactions();
        assertEquals(2, txs.size());
        assertEquals(-300, txs.get(1).getAmount());
    }

    @Test
    void withdraw_moreThanBalance_shouldThrowException() {
        account.deposit(100);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    void deposit_negativeAmount_shouldThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void withdraw_negativeAmount_shouldThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-100);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void printTransactionsOn_shouldOnlyPrintGivenDate() {
        account.deposit(100);
        account.withdraw(50);
        account.deposit(200);
        account.printTransactionsOn(LocalDate.now());

        assertEquals(3, account.getTransactions().size());
    }

    @Test
    void printTransactionsAbove_shouldFilterCorrectly() {
        account.deposit(100);
        account.withdraw(50);
        account.deposit(700);
        account.withdraw(400);

        account.printTransactionsAbove(300);
        // Should print deposit 700 and withdrawal 400
    }
}
