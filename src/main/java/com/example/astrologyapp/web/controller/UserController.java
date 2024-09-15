package com.example.astrologyapp.web.controller;

import com.example.astrologyapp.model.dto.LoginDto;
import com.example.astrologyapp.model.dto.RegisterUserDto;
import com.example.astrologyapp.service.UserService;
import com.example.astrologyapp.util.customException.ExistingUserException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if(!model.containsAttribute("loginFormDto")){
            model.addAttribute("loginFormDto", new LoginDto());
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid LoginDto loginFormDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginFormDto", loginFormDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginFormDto", bindingResult);
            return "redirect:/login";
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model){
        if(!model.containsAttribute("registerUserDto")){
            model.addAttribute(new RegisterUserDto());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegisterUserDto registerUserDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerUserDto", registerUserDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDto", bindingResult);
            return "redirect:/register";
        }
        try{
            userService.registerUser(registerUserDto);
        }catch (ExistingUserException e){
            redirectAttributes.addFlashAttribute("registerUserDto", registerUserDto);
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/register";
        }
        return "redirect:/";
    }

    @GetMapping("/edit-profile")
    public String editProfile(Model model){
        return "/edit-profile";
    }


}
