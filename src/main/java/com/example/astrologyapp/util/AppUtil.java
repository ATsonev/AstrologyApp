package com.example.astrologyapp.util;

import com.example.astrologyapp.model.User;
import com.example.astrologyapp.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class AppUtil {

    private final UserRepository userRepository;

    public AppUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = null;

        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                email = ((UserDetails) principal).getUsername();
            } else {
                email = principal.toString();
            }
        }

        User user = userRepository.findByEmail(email).orElseThrow(NoSuchElementException::new);
        return user;
    }

}
