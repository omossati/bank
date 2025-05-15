package org.example;

import org.example.model.Account;

public class Main {
    public static void main(String[] args) {

        Account account = new Account();

        //Some operations
        account.deposit(1000);
        account.deposit(500);
        account.withdraw(200);

        System.out.println("\n--- Transactions ABOVE 300 ---");
        account.printTransactionsAbove(300);

        //Print statements
        account.printTransactions(account.getTransactions());
    }
}