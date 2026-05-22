package com.returnshield.dsa;

import com.returnshield.models.Transaction;

import java.util.LinkedList;

public class TransactionHistoryManager {

    private LinkedList<Transaction> transactionList;

    public TransactionHistoryManager() {

        transactionList = new LinkedList<>();
    }

    public void addTransaction(Transaction transaction) {

        transactionList.add(transaction);
    }

    public LinkedList<Transaction> getTransactions() {

        return transactionList;
    }
}