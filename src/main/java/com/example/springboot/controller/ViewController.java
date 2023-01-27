package com.example.springboot.controller;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/views")
public class ViewController {

    @GetMapping
    public String hello(){
        return "index.html";
    }
}
