package com.example.springboot.dto;

import com.example.springboot.validation.CustomValidation;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    //    controller에서 if문 코드로 작성하지않고 기본 Spring Boot에서 제공하는 Validation 어노테이션 사용
    @CustomValidation(min = 1, message = "이름 길이 확인")
    private String name;
    @CustomValidation(min = 1,max = 2,message = "1이최소 2가최대야")
    private Integer age;
}
