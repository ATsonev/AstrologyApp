package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table
@Entity(name = "contacts")
public class Contact extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    @Lob
    private String message;
    @Column(name = "date_and_time_submitted")
    private LocalDateTime dateAndTimeSubmitted;

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

    public LocalDateTime getDateAndTimeSubmitted() {
        return dateAndTimeSubmitted;
    }

    public void setDateAndTimeSubmitted(LocalDateTime dateAndTimeSubmitted) {
        this.dateAndTimeSubmitted = dateAndTimeSubmitted;
    }
}
