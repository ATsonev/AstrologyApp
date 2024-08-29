package com.example.astrologyapp.service;

import org.springframework.security.core.userdetails.User;
import com.example.astrologyapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<com.example.astrologyapp.model.User> byEmail = userRepository.findByEmail(email);

        if (byEmail.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        com.example.astrologyapp.model.User user = byEmail.get();

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();

    }
}
