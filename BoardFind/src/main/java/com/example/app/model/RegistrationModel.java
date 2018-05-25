package com.example.app.model;

import com.example.app.Annotations.isPasswordMatching;

import javax.validation.constraints.Size;

@isPasswordMatching
public class RegistrationModel {

    @Size(min = 5, max = 100, message = "Username too short")
    private String username;

    @Size(min = 8, max = 150, message = "Password too short")
    private String password;

    private String confirmed_password;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmed_password() {
        return confirmed_password;
    }

    public void setConfirmed_password(String confirmed_password) {
        this.confirmed_password = confirmed_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
