package com.example.springboot.twoException;

import com.example.springboot.twoController.DongController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackageClasses = DongController.class)
public class DongException {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception exception) {
        log.error("errorClass {}",exception.getClass());
        log.error("errorMessage {}",exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getClass().getName());
    }
}
