package com.returnshield.dsa;

import com.returnshield.models.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerManager {

    private ArrayList<Customer> customerList;
    private HashMap<Integer, Customer> customerMap;

    public CustomerManager() {
        customerList = new ArrayList<>();
        customerMap = new HashMap<>();
    }

    public void addCustomer(Customer customer) {

        customerList.add(customer);

        customerMap.put(customer.getCustomerId(), customer);
    }

    public Customer searchCustomer(int id) {

        return customerMap.get(id);
    }

    public ArrayList<Customer> getAllCustomers() {

        return customerList;
    }
}