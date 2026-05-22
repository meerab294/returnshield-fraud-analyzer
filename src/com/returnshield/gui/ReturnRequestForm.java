package com.returnshield.gui;
import com.returnshield.database.FileManager;
import com.returnshield.models.Customer;
import com.returnshield.models.Product;
import com.returnshield.models.ReturnRequest;
import com.returnshield.services.AppData;
import com.returnshield.services.FraudDetectionService;

import javax.swing.*;
import java.awt.*;

public class ReturnRequestForm extends JFrame {

    JTextField customerField;
    JTextField productField;
    JTextField priceField;

    JButton submitButton;

    public ReturnRequestForm() {

        setTitle("Return Request Form");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(new Color(35,35,35));

        JLabel heading = new JLabel("Create Return Request");

        heading.setBounds(100, 30, 300, 40);

        heading.setForeground(Color.WHITE);

        heading.setFont(new Font("Arial",
                Font.BOLD,
                24));

        add(heading);

        JLabel customerLabel =
                new JLabel("Customer Name");

        customerLabel.setBounds(50,100,150,30);

        customerLabel.setForeground(Color.WHITE);

        add(customerLabel);

        customerField = new JTextField();

        customerField.setBounds(200,100,200,30);

        add(customerField);

        JLabel productLabel =
                new JLabel("Product Name");

        productLabel.setBounds(50,150,150,30);

        productLabel.setForeground(Color.WHITE);

        add(productLabel);

        productField = new JTextField();

        productField.setBounds(200,150,200,30);

        add(productField);

        JLabel priceLabel =
                new JLabel("Product Price");

        priceLabel.setBounds(50,200,150,30);

        priceLabel.setForeground(Color.WHITE);

        add(priceLabel);

        priceField = new JTextField();

        priceField.setBounds(200,200,200,30);

        add(priceField);

        submitButton =
                new JButton("Submit Return");

        submitButton.setBounds(160,280,160,40);

        submitButton.setBackground(
                new Color(0,153,255));

        submitButton.setForeground(Color.WHITE);

        add(submitButton);

        submitButton.addActionListener(
                e -> submitRequest()
        );

        setVisible(true);
    }

    private void submitRequest() {

        String customerName =
                customerField.getText();

        String productName =
                productField.getText();

        double price =
                Double.parseDouble(
                        priceField.getText()
                );

        Customer customer =
                new Customer(
                        1,
                        customerName,
                        customerName + "@gmail.com",
                        5,
                        6,
                        0
                );

        Product product =
                new Product(
                        1,
                        productName,
                        price
                );

        int fraudScore =
                FraudDetectionService
                        .calculateFraudScore(
                                customer,
                                product
                        );

        customer.setFraudScore(fraudScore);

        ReturnRequest request =
                new ReturnRequest(
                        1,
                        customer,
                        product,
                        "Damaged Product",
                        fraudScore
                );

        AppData.returnQueueManager
                .addRequest(request);
        FileManager.saveReturnRequest(request);

        if(fraudScore >= 40) {

            AppData.fraudQueueManager
                    .addFraudCase(request);
        }

        JOptionPane.showMessageDialog(this,
                "Return Request Submitted\n"
                        + "Fraud Score: "
                        + fraudScore
                        + "\nLevel: "
                        + FraudDetectionService
                        .getFraudLevel(fraudScore));

        clearFields();
    }

    private void clearFields() {

        customerField.setText("");

        productField.setText("");

        priceField.setText("");
    }
}