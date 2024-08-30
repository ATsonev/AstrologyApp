package com.example.astrologyapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentsController {

    @GetMapping("/appointment")
    public String appointments(){
        return "appointment";
    }

}
