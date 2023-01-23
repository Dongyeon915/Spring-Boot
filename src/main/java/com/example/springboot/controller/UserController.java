package com.example.springboot.controller;

import com.example.springboot.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 복수 s
@RestController
@RequestMapping("/users")
public class UserController {

    //    리턴 받기전에 매개타입으로 들어올때 실행되는게 before 그후 내보내는 타입이 나갈때는 after
    //    그후 작업 하고싶으면 after리터닝
    //    어떤 파라미터를 받고싶으면 before
    //    return으로 값이 나가야하면 after returning
    @GetMapping
    public String hello() {
        return "hello";
    }

    @PostMapping("/setuser")
//    BindingResult는 오류가 발생할 경우 오류 내용을 보관하는 스프링 프레임워크에서 제공하는 객체
    public Object setUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        return userDto;
    }

//    @PostMapping("/set")
//    public Object setInfo(@Valid @RequestBody Object obj){
//        return obj;
//    }
}
