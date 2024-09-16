package com.example.astrologyapp.service;

import com.example.astrologyapp.model.dto.userDto.ChangePasswordDto;
import com.example.astrologyapp.model.dto.userDto.EdiUserDto;
import com.example.astrologyapp.model.dto.userDto.RegisterUserDto;

public interface UserService {

    void registerUser(RegisterUserDto registerUserDto);

    EdiUserDto getUserProfile();

    void editUserProfile(EdiUserDto ediUserDto);

    String changePassord(ChangePasswordDto changePasswordDto);
}
