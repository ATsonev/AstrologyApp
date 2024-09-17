package com.example.astrologyapp.web.controller;

import com.example.astrologyapp.model.dto.ContactDto;
import com.example.astrologyapp.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public String contacts(Model model){
        if(!model.containsAttribute("contactDto")){
            model.addAttribute("contactDto", new ContactDto());
        }
        return "contacts";
    }

    @PostMapping("/contacts")
    public String submitContact(@Valid ContactDto contactDto,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("contactDto", contactDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactDto", bindingResult);
            return "redirect:/contacts";
        }
        contactService.submitContact(contactDto);
        return "redirect:/contacts";
    }

}
