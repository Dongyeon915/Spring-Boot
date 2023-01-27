package com.example.springboot.controller.example;

import com.example.springboot.dto.Dong;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ajax")
public class AjaxController {

    @GetMapping
    public String ajax(){
        return "안녕";
    }

    @PostMapping("/set")
    public Dong setUser(@RequestBody Dong dong){
        return dong;
    }
}
