package com.example.springboot.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Dong {

    @NotNull
    @Size(min = 4,max = 5)
    @NotNull
    private String name;
    @Size(min = 1, max = 10)
    private String age;
}
