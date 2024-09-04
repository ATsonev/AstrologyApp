package com.example.astrologyapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Set 401 status code for failed authentication
        response.setContentType("application/json");

        String errorMessage;
        if (exception.getMessage().equalsIgnoreCase("There is no user with this email or phone number in our system")) {
            errorMessage = "There is no user with this email or phone number in our system";
        } else if (exception.getMessage().equalsIgnoreCase("Bad credentials")) {
            errorMessage = "Incorrect password, please try again.";
        } else {
            errorMessage = "Authentication failed - " + exception.getMessage();
        }

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", errorMessage);

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(responseBody));
        writer.flush();
    }
}
