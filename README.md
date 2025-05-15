# Bank Account Application

This is a Java project simulating a personal bank account with basic operations, transaction tracking, and statement printing.

---

## Features

- **Deposit and Withdrawal**  
  Allows depositing and withdrawing money with validation (no negative amounts, no overdrafts).

- **Transaction History**  
  Records each transaction with date, amount, and resulting balance.

- **Transaction Filtering and Statement Printing**  
  Supports printing transaction statements filtered by:
    - Minimum amount (above a threshold)
    - Maximum amount (below a threshold)
    - Specific date
    -  Transactions in a date range
    -  Only withdrawals & Only Deposits

---

## User Stories

- **US1:** As a bank client, I want to make a deposit in my account to save money.
- **US2:** As a bank client, I want to make a withdrawal from my account to retrieve some or all of my savings.

---

## Implementation Details

- **`Account` class:** Handles balance management and stores a list of `Transaction` objects.
- **`Transaction` class:** Represents individual transactions with date, amount, and balance at that time.
- **`Main` class:** Example usage demonstrating deposits, withdrawals, and printing filtered statements.
- **Unit tests:** Provided with JUnit 5 to validate deposit, withdrawal, and error conditions.

---

## Testing

### Unit Tests

Unit tests are written using **JUnit 5** to ensure the core banking logic behaves as expected. See `AccountTest.java`.

### BDD with Cucumber

Cucumber is integrated for Behavior-Driven Development (BDD). Tests are defined in natural language using `.feature` files, making scenarios more readable and user-focused.

- Feature File: `account.feature`
- Step Definitions: `AccountSteps.java`
- Test Runner: `RunCucumberTest.java`

#### Example Scenario:

```gherkin
Scenario: Deposit money
  Given I have an empty account
  When I deposit 100
  Then my balance should be 100
```
---

## Built using Maven

- **To build the project**: mvn clean compile
- **To run tests**: mvn test

---

## Future Enhancements
- More advanced features such as daily withdrawal limits, more transaction filtering
- Export statements to file.
- Adding authentication to accounts with Account No & PIN code.
- Admin dashboard to manage all accounts.

