package com.returnshield.services;

import com.returnshield.models.Customer;
import com.returnshield.models.Product;

public class FraudDetectionService {

    public static int calculateFraudScore(Customer customer,
                                          Product product) {

        int score = 0;

        if(customer.getTotalReturns() > 5) {

            score += 30;
        }

        if(product.getPrice() > 50000) {

            score += 25;
        }

        if(customer.getTotalPurchases() < 3) {

            score += 20;
        }

        if(customer.getTotalReturns() >
                customer.getTotalPurchases()) {

            score += 25;
        }

        return score;
    }

    public static String getFraudLevel(int score) {

        if(score >= 70) {

            return "HIGH RISK";
        }
        else if(score >= 40) {

            return "MEDIUM RISK";
        }

        return "SAFE";
    }
}