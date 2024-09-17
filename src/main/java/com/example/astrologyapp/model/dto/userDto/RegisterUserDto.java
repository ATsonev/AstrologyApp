package com.example.astrologyapp.model.dto.userDto;

import com.example.astrologyapp.util.annotation.PasswordMatches;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@PasswordMatches(message = "The passwords doesn't match")
public class RegisterUserDto{

    @NotBlank(message = "The first name cannot be empty")
    @Length(min = 2, max = 50, message = "The first name should be between 2 and 50 characters")
    private String firstName;
    @NotBlank(message = "The last name should be atleast 3 characters")
    @Length(min = 2, max = 50, message = "The last name should be between 2 and 50 characters")
    private String lastName;
    @Email(message = "Please write valid email")
    @NotBlank(message = "The email cannot be empty")
    private String email;
    @Length(min = 5, max = 18, message = "The phone length should be between 5 and 18 numbers")
    @Pattern(regexp = "^\\+\\d+$", message = "Phone must start with + and contain only numbers")
    /*@Pattern(regexp = "\\d+", message = "Phone must contain only numbers")*/
    private String phone;
    private String skype;
    private String cityOfBirth;
    @Length(min = 5, max = 20, message = "The password length should be between 5 and 20 characters")
    private String password;
    private String confirmPassword;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }
}
