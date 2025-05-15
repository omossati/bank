package stepdefs;

import io.cucumber.java.en.*;
import org.example.model.Account;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class AccountSteps {

    private Account account;
    private Exception thrownException;

    @Given("I have a new bank account")
    public void i_have_a_new_bank_account() {
        account = new Account();
        thrownException = null;
    }

    @When("I deposit {int}")
    public void i_deposit(int amount) {
        account.deposit(amount);
    }

    @When("I withdraw {int}")
    public void i_withdraw(int amount) {
        account.withdraw(amount);
    }

    @Then("the balance should be {int}")
    public void the_balance_should_be(int expected) {
        assertEquals(expected, account.getBalance());
    }

    @When("I try to withdraw {int}")
    public void i_try_to_withdraw(int amount) {
        try {
            account.withdraw(amount);
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @When("I try to deposit {int}")
    public void i_try_to_deposit(int amount) {
        try {
            account.deposit(amount);
        } catch (Exception e) {
            thrownException = e;
        }
    }

    @Then("I should get an error {string}")
    public void i_should_get_an_error(String message) {
        assertNotNull(thrownException, "Expected exception but none was thrown.");
        assertEquals(message, thrownException.getMessage());
    }
}
