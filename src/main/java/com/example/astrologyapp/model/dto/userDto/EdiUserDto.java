package com.example.astrologyapp.model.dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class EdiUserDto {

    @NotBlank(message = "The first name cannot be empty")
    @Length(min = 2, max = 50, message = "The first name should be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "The first name cannot be empty")
    @Length(min = 2, max = 50, message = "The first name should be between 2 and 50 characters")
    private String lastName;
    @Email
    @NotBlank
    private String email;
    @Length(min = 5, max = 18, message = "The phone length should be between 5 and 18 numbers")
    @Pattern(regexp = "^\\+\\d+$", message = "Phone must start with + and contain only numbers")
    private String phone;
    private String password;
    private String skype;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

}
