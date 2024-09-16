package com.example.astrologyapp.util.validator;

import com.example.astrologyapp.model.dto.userDto.ChangePasswordDto;
import com.example.astrologyapp.model.dto.userDto.RegisterUserDto;
import com.example.astrologyapp.util.annotation.ChangePasswordMatches;
import com.example.astrologyapp.util.annotation.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordMatchesValidator implements ConstraintValidator<ChangePasswordMatches, ChangePasswordDto> {

    private String message;

    @Override
    public void initialize(ChangePasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(ChangePasswordDto dto, ConstraintValidatorContext context) {
        if (dto.getNewPassword() == null || dto.getConfirmNewPassword() == null) {
            return true;
        }

        boolean isValid = dto.getNewPassword().equals(dto.getConfirmNewPassword());

        if (!isValid) {
            context.unwrap(HibernateConstraintValidatorContext.class)
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("confirmNewPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return isValid;
    }
}
