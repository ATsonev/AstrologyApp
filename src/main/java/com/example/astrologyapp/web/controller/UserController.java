package com.example.astrologyapp.web.controller;

import com.example.astrologyapp.model.dto.RegisterUserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
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
        return "redirect:/";
    }


}
