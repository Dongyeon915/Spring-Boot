package com.example.springboot.twoController;

import com.example.springboot.twoDto.Dong;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/dongs")
public class DongController {

    @GetMapping
    public String helloDong() {
        return "안녕 확인";
    }

    @PostMapping("/set")
    public Dong setDong(@RequestBody @Valid Dong dong, BindingResult bindingResult) {
        return dong;
    }
}
