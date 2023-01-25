package com.example.springboot.controller;

import com.example.springboot.dto.UserDto;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping
    public Object getException(@RequestParam String name){
        return "hello";
    }

    @PostMapping
    public Object setUser(@Valid @RequestBody UserDto userDto) {
        System.out.println("[UserController] " + userDto.toString());
        userDto.setAge(userDto.getAge() - 1);
        return userDto;
    }
}
