package com.example.astrologyapp.model.dto.userDto;

import com.example.astrologyapp.util.annotation.ChangePasswordMatches;
import org.hibernate.validator.constraints.Length;

@ChangePasswordMatches
public class ChangePasswordDto {
    private String currentPassword;
    @Length(min = 5, max = 20, message = "The password length should be between 5 and 20 characters")
    private String newPassword;
    private String confirmNewPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
