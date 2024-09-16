package com.example.astrologyapp.util.annotation;

import com.example.astrologyapp.util.validator.ChangePasswordMatchesValidator;
import com.example.astrologyapp.util.validator.PasswordMatchesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ChangePasswordMatchesValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChangePasswordMatches {
    String message() default "Confirm password doesn't match the new password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
