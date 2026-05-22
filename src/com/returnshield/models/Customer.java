package com.returnshield.models;
public class Customer {
    private int customerId;
    private String name;
    private String email;
    private int totalPurchases;
    private int totalReturns;
    private int fraudScore;
    public Customer(int customerId, String name, String email,
                    int totalPurchases, int totalReturns, int fraudScore) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.totalPurchases = totalPurchases;
        this.totalReturns = totalReturns;
        this.fraudScore = fraudScore;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getTotalPurchases() {
        return totalPurchases;
    }
    public int getTotalReturns() {
        return totalReturns;
    }
    public int getFraudScore() {
        return fraudScore;
    }
    public void setFraudScore(int fraudScore) {
        this.fraudScore = fraudScore;
    }
    @Override
    public String toString() {
        return customerId + " | " + name + " | Fraud Score: " + fraudScore;
    }
}
