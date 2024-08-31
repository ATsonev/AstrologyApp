package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import com.example.astrologyapp.model.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table
@Entity(name = "users")
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String password;
    private String skype;
    @Column(name = "date_and_hour_of_birth")
    private LocalDateTime dateAndHourOfBirth;
    @Column(name = "city_of_birth")
    private String cityOfBirth;
    @Column(name = "date_and_time_registered")
    private LocalDateTime dateAndTimeRegistered;
    private String comment;
    private UserRole role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getDateAndTimeRegistered() {
        return dateAndTimeRegistered;
    }

    public void setDateAndTimeRegistered(LocalDateTime dateAndTimeRegistered) {
        this.dateAndTimeRegistered = dateAndTimeRegistered;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public LocalDateTime getDateAndHourOfBirth() {
        return dateAndHourOfBirth;
    }

    public void setDateAndHourOfBirth(LocalDateTime dateAndHourOfBirth) {
        this.dateAndHourOfBirth = dateAndHourOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

}
