package com.example.springboot.controller.example;

import com.example.springboot.dto.Dong;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.net.http.HttpHeaders;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/dongs")
@CrossOrigin(origins = "*")
public class DongController {

    @GetMapping
    public String helloDong() {
        return "안녕 확인";
    }

    @PostMapping("/set/controller")
//    BindingResult는 에러핸들링을 해줄때 에러 클래스에 저장되어있다. 그냥 파라미터로 붙이게되면 문제가있음
    public Dong setDongByController(@RequestBody @Valid Dong dong, HttpServletRequest httpServletRequest, BindingResult result) {
        if(result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                log.info("Field: {}", error.getField());
                log.info("Field: {}", error.getDefaultMessage());
            }
        }
        Iterator<String> itr = httpServletRequest.getHeaderNames().asIterator();
        while (itr.hasNext()) {
            String headerName = itr.next();
            log.info("name: {}, value: {}", headerName, httpServletRequest.getHeader(headerName));
        }
//        Set<Entry<String, List<String>>> entrySet = headers.map().entrySet();
//        for (Entry e : entrySet) {
//            log.info("key: {}, value: {}", e.getKey(), e.getValue());
//        }
        return dong;
    }

    @PostMapping("/notnull")
    public Dong setArgumentNotValidException(@Valid @RequestBody Dong dong,BindingResult result){
        if (result.hasErrors()){
           List<FieldError> fieldErrors = result.getFieldErrors();
           for (FieldError error : fieldErrors){
              log.error("이것이 필드여" + error.getField());
              log.error("이것이 거절된 값" + (String) error.getRejectedValue());
              log.error("이것이 기본에러 메세지여" + error.getDefaultMessage());
           }
        }
        return dong;
    }

    @PostMapping("/set")
    public Dong setDong(@RequestBody @Valid Dong dong) {
        return dong;
    }
}
