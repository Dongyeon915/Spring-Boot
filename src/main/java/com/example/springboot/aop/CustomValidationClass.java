package com.example.springboot.aop;

import com.example.springboot.dto.UserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidationClass implements ConstraintValidator<CustomValidation, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("커스텀 성공");
        if (value instanceof UserDto) {
            UserDto dto = (UserDto) value;
            if (dto.getAge() > 5 || dto.getAge() <= 1) {
                return false;
            } else {
                System.out.println("정확한 나이대");
                return true;
            }
        }
        return false;
    }
}
