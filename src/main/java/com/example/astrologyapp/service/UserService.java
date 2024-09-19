package com.example.astrologyapp.service;

import com.example.astrologyapp.model.User;
import com.example.astrologyapp.model.dto.ContactDto;
import com.example.astrologyapp.model.dto.userDto.ChangePasswordDto;
import com.example.astrologyapp.model.dto.userDto.EdiUserDto;
import com.example.astrologyapp.model.dto.userDto.RegisterUserDto;

import java.util.List;

public interface UserService {

    void registerUser(RegisterUserDto registerUserDto);

    EdiUserDto getUserProfile();

    void editUserProfile(EdiUserDto ediUserDto);

    String changePassword(ChangePasswordDto changePasswordDto);

    List<EdiUserDto> getAllUsers();
}
