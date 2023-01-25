package com.example.springboot.twoDto;

import com.example.springboot.validation.CustomValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Dong {

    @NotNull
    private String name;
    @Size(min = 1, max = 10)
    private String age;
}
