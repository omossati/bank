package org.example;

import org.example.model.Account;

public class Main {
    public static void main(String[] args) {

        Account account = new Account();

        account.deposit(1000);
        account.deposit(500);
        account.withdraw(200);

        System.out.println("\n--- Full Statement ---");
        account.printTransactions(account.getTransactions());

        System.out.println("\n--- Deposits Only ---");
        account.printTransactionsAbove();

        System.out.println("\n--- Withdrawals Only ---");
        account.printTransactionsBelow();

        System.out.println("\n--- Transactions on Today ---");
        account.printTransactionsOn(LocalDate.now());

        System.out.println("\n--- Transactions Between Dates ---");
        LocalDate from = LocalDate.now().minusDays(1);
        LocalDate to = LocalDate.now().plusDays(1);
        account.printStatementBetween(from, to);
    }
}