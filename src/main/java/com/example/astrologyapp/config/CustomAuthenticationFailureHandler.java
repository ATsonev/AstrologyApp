package com.example.astrologyapp.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        String errorMessage;
        if (exception.getMessage().equalsIgnoreCase("There is no user with this email or phone number in our system")) {
            errorMessage = "There is no user with this email or phone number in our system";
        } else if (exception.getMessage().equalsIgnoreCase("Bad credentials")) {
            errorMessage = "Incorrect password, please try again.";
        } else {
            errorMessage = "Authentication failed - " + exception.getMessage();
        }

        response.sendRedirect("/login?error=" + errorMessage);
    }
}
