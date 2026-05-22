package com.returnshield.models;

public class ReturnRequest {

    private int requestId;
    private Customer customer;
    private Product product;
    private String reason;
    private int fraudScore;

    public ReturnRequest(int requestId, Customer customer,
                         Product product, String reason, int fraudScore) {

        this.requestId = requestId;
        this.customer = customer;
        this.product = product;
        this.reason = reason;
        this.fraudScore = fraudScore;
    }

    public int getRequestId() {
        return requestId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public String getReason() {
        return reason;
    }

    public int getFraudScore() {
        return fraudScore;
    }

    @Override
    public String toString() {
        return "Request ID: " + requestId +
                " | Customer: " + customer.getName() +
                " | Fraud Score: " + fraudScore;
    }
}