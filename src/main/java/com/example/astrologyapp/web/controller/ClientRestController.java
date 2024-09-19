package com.example.astrologyapp.web.controller;

import com.example.astrologyapp.model.User;
import com.example.astrologyapp.model.dto.userDto.EdiUserDto;
import com.example.astrologyapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ClientRestController {

    private final UserService userService;

    public ClientRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<EdiUserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}