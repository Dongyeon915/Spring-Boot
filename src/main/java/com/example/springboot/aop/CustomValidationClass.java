package com.example.springboot.aop;

import com.example.springboot.dto.UserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidationClass implements ConstraintValidator<CustomValidation, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("커스텀 성공");
        return true;
        }
    }