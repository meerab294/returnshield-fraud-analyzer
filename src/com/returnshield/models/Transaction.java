package com.returnshield.models;

public class Transaction {

    private int transactionId;
    private Customer customer;
    private Product product;
    private double amount;

    public Transaction(int transactionId,
                       Customer customer,
                       Product product,
                       double amount) {

        this.transactionId = transactionId;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }
}