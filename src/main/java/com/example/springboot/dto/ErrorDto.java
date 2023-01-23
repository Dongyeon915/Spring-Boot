package com.example.springboot.dto;

import lombok.Data;

@Data
public class ErrorDto {
    private String filed;
    private String message;
}
