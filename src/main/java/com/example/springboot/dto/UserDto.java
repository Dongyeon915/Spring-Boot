package com.example.springboot.dto;

import com.example.springboot.aop.CustomValidation;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    //    controller에서 if문 코드로 작성하지않고 기본 Spring Boot에서 제공하는 Validation 어노테이션 사용
    @Size(min = 2,max = 10)
    private String name;
//    @CustomValidation
    private Integer age;
}
