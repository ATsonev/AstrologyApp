package com.example.astrologyapp.model.dto;

import org.hibernate.validator.constraints.Length;

public class LoginDto {

    private String username;
    @Length(min = 5, max = 20, message = "The password length should be between 5 and 20 characters")
    private String password;

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
}
