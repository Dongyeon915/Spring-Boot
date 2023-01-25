package com.example.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
public class UserResponse extends UserDto {

    @JsonProperty("age")
    private String ageStr;
}