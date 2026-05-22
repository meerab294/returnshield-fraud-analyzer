package com.returnshield.gui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginFrame() {

        setTitle("ReturnShield Fraud Analyzer");

        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(new Color(24, 24, 24));

        JLabel title = new JLabel("ReturnShield Login");

        title.setBounds(130, 30, 300, 40);

        title.setForeground(Color.WHITE);

        title.setFont(new Font("Arial", Font.BOLD, 28));

        add(title);

        JLabel userLabel = new JLabel("Username");

        userLabel.setBounds(70, 100, 100, 30);

        userLabel.setForeground(Color.WHITE);

        add(userLabel);

        usernameField = new JTextField();

        usernameField.setBounds(180, 100, 200, 30);

        add(usernameField);

        JLabel passLabel = new JLabel("Password");

        passLabel.setBounds(70, 150, 100, 30);

        passLabel.setForeground(Color.WHITE);

        add(passLabel);

        passwordField = new JPasswordField();

        passwordField.setBounds(180, 150, 200, 30);

        add(passwordField);

        loginButton = new JButton("Login");

        loginButton.setBounds(180, 220, 120, 40);

        loginButton.setBackground(new Color(0, 153, 255));

        loginButton.setForeground(Color.WHITE);

        loginButton.setFocusPainted(false);

        add(loginButton);

        loginButton.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String username = usernameField.getText();

        String password = new String(passwordField.getPassword());

        if(username.equals("admin") && password.equals("1234")) {

            JOptionPane.showMessageDialog(this,
                    "Login Successful");

            new AdminDashboard();

            dispose();
        }
        else {

            JOptionPane.showMessageDialog(this,
                    "Invalid Username or Password");
        }
    }
}