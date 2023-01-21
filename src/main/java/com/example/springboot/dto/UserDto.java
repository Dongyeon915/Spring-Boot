package com.example.springboot.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserDto {
    @NonNull
    private String name;
    @Min(20)
    private Integer age;
}
