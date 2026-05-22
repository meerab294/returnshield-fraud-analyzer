package com.returnshield.services;

import com.returnshield.models.Customer;

public class SearchService {

    public static Customer searchCustomer(int id) {

        return AppData.customerManager
                .searchCustomer(id);
    }
}