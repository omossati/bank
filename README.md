# Bank Account Application

This is a Java project simulating a personal bank account with basic operations, transaction tracking, and statement printing.

---

## Features

- **Deposit and Withdrawal**  
  Allows depositing and withdrawing money with validation.

- **Transaction History**  
  Records each transaction with date, amount, and resulting balance.

- **Transaction and Statement Printing**  

---

## User Stories

- **US1:** As a bank client, I want to make a deposit in my account to save money.
- **US2:** As a bank client, I want to make a withdrawal from my account to retrieve some or all of my savings.

---

## Implementation Details

- **`Account` class:** Handles balance management and stores a list of `Transaction` objects.
- **`Transaction` class:** Represents individual transactions with date, amount, and balance at that time.
- **`Main` class:** Example usage demonstrating deposits, withdrawals, and printing statements.
- **Unit tests:** Provided with JUnit 5 to validate deposit, withdrawal, and error conditions.

---

## Built using Maven

- **To build the project**: mvn clean compile
- **To run tests**: mvn test
- 
---

