package com.example.plantilla_hack.adapter.in.rest.security.dto;

public class RegisterUserDTO {
    private String email;

    private String password;

    private String fullName;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    // getters and setters here...
}