package com.example.astrologyapp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactDto {
    @NotBlank(message = "The field is required")
    private String name;
    @NotBlank(message = "The field is required")
    @Email(message = "Please write valid email")
    private String email;
    private String phone;
    @NotBlank(message = "The field is required")
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
