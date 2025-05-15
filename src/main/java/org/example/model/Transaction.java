package org.example.model;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final int amount;
    private final int balance;

    public Transaction(LocalDate date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    //Getters
    public LocalDate getDate() {
        return date;
    }

    public int getBalance() {
        return balance;
    }

    public int getAmount() {
        return amount;
    }
}
