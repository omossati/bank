package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {
    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    public void withdraw(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance -= amount;
        transactions.add(new Transaction(LocalDate.now(), -amount, balance));
    }

    public void printTransactionsAbove(int threshold) {
        List<Transaction> filtered = transactions.stream()
                .filter(t -> Math.abs(t.amount()) >= threshold)
                .collect(Collectors.toList());
        printTransactions(filtered);
    }

    private void printTransactions(List<Transaction> txs) {
        System.out.println("DATE       | AMOUNT  | BALANCE");
        for (int i = txs.size() - 1; i >= 0; i--) {
            Transaction t = txs.get(i);
            System.out.printf("%s | %7d | %7d%n", t.getDate(), t.getAmount(), t.getBalance());
        }
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public int getBalance() {
        return balance;
    }
}
