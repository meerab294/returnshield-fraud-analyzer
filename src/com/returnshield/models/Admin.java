package com.returnshield.models;

public class Admin {

    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUser, String enteredPass) {
        return username.equals(enteredUser)
                && password.equals(enteredPass);
    }
}