package com.example.springboot.controller.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/ajax")
public class AjaxController {

    @PostMapping("/info")
    public void ajax(){

    }
}
