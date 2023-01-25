package com.example.springboot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class CustomValidationClass implements ConstraintValidator<CustomValidation, Object> {

    private int min;
    private int max;

    // 어노테이션이션에 정의된 함수 정보를 가져와서 조정이가능
    @Override
    public void initialize(CustomValidation constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("커스텀 성공");
        if (value instanceof Integer) {
            int intValue = (int) value;
            if (intValue < min) {
                return false;
            }
            if (intValue > max) {
                return false;
            }
        } else if (value instanceof String) {
            String strValue = (String) value;
            if (strValue.length() < min) {
                return false;
            }
            if (strValue.length() > max) {
                return false;
            }
        } else if (value instanceof List<?>) {
            List list = (List) value;
            if (list.size() < min) {
                return false;
            }
            if (list.size() > max) {
                return false;
            }
        }
        return true;
    }
}