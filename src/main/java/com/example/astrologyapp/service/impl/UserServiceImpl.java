package com.example.astrologyapp.service.impl;

import com.example.astrologyapp.model.Contact;
import com.example.astrologyapp.model.User;
import com.example.astrologyapp.model.dto.ContactDto;
import com.example.astrologyapp.model.dto.userDto.ChangePasswordDto;
import com.example.astrologyapp.model.dto.userDto.EdiUserDto;
import com.example.astrologyapp.model.dto.userDto.RegisterUserDto;
import com.example.astrologyapp.model.enums.UserRole;
import com.example.astrologyapp.repository.UserRepository;
import com.example.astrologyapp.service.UserService;
import com.example.astrologyapp.util.AppUtil;
import com.example.astrologyapp.util.customException.ExistingUserException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AppUtil appUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, AppUtil appUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.appUtil = appUtil;
    }

    @Override
    public void registerUser(RegisterUserDto registerUserDto) {
        Optional<User> byEmail = userRepository.findByEmail(registerUserDto.getEmail());
        if(byEmail.isPresent()){
            throw new ExistingUserException("User with this email already exist in out system");
        }
        Optional<User> byPhone = userRepository.findByPhone(registerUserDto.getPhone());
        if(byPhone.isPresent()){
            throw new ExistingUserException("User with this phone number already exist in out system");
        }

        User user = modelMapper.map(registerUserDto, User.class);
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        user.setDateAndTimeRegistered(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public EdiUserDto getUserProfile() {
        User currentUser = appUtil.getCurrentUser();
        return modelMapper.map(currentUser, EdiUserDto.class);
    }

    @Override
    public void editUserProfile(EdiUserDto ediUserDto) {
        User currentUser = appUtil.getCurrentUser();
        currentUser.setFirstName(ediUserDto.getFirstName());
        currentUser.setLastName(ediUserDto.getLastName());
        currentUser.setEmail(ediUserDto.getEmail());
        currentUser.setPhone(ediUserDto.getPhone());
        currentUser.setSkype(ediUserDto.getSkype());

        userRepository.save(currentUser);
    }

    @Override
    public String changePassword(ChangePasswordDto changePasswordDto) {
        User currentUser = appUtil.getCurrentUser();
        if(!passwordEncoder.matches(changePasswordDto.getCurrentPassword(), currentUser.getPassword())){
            return "Current password doesn't match";
        }else {
            currentUser.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
            userRepository.save(currentUser);
            return "Password successfully changed";
        }
    }

    @Override
    public List<EdiUserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u -> modelMapper.map(u, EdiUserDto.class))
                .toList();
    }


}
