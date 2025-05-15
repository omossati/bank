
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

    }

    @Test
    void withdraw_shouldDecreaseBalanceAndRecordTransaction() {
        account.deposit(1000);
        account.withdraw(300);

        assertEquals(700, account.getBalance());

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

}
