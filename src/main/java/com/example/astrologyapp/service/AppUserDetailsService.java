package com.example.astrologyapp.service;

import com.example.astrologyapp.util.customException.UserNotFoundException;
import org.springframework.security.core.userdetails.User;
import com.example.astrologyapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



import java.util.Optional;

public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<com.example.astrologyapp.model.User> byEmail = userRepository.findByEmail(email);
        Optional<com.example.astrologyapp.model.User> byPhone = userRepository.findByPhone(email);

        if (byEmail.isEmpty() && byPhone.isEmpty()) {
            throw new UserNotFoundException("There is no user with this email or phone number in our system");
        }

        com.example.astrologyapp.model.User user = byEmail.orElseGet(byPhone::get);

        return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
    }
}
