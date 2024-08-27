package com.example.astrologyapp.model;

import com.example.astrologyapp.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table
@Entity(name = "customers")
public class Customer extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_and_hour_of_birth")
    private LocalDateTime dateAndHourOfBirth;
    @Column(name = "city_of_birth")
    private String cityOfBirth;
    @Column(unique = true)
    private String phone;
    private String skype;
    @Column(name = "social_media_profile")
    private String socialMediaProfile;
    @Column(name = "date_and_time_registered")
    private LocalDateTime dateAndTimeRegistered;
    private String comment;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getSocialMediaProfile() {
        return socialMediaProfile;
    }

    public void setSocialMediaProfile(String socialMediaProfile) {
        this.socialMediaProfile = socialMediaProfile;
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
}
