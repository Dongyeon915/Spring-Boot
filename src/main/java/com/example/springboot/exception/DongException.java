package com.example.springboot.exception;

import com.example.springboot.controller.example.DongController;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackageClasses = DongController.class)
public class DongException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception exception) {
        log.error("errorClass {}", exception.getClass());
        log.error("errorMessage {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getClass().getName());
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> exception02(MethodArgumentNotValidException exception) {
//        BindingResult bindingResult = exception.getBindingResult();
//        if (bindingResult.hasErrors()) {
//            List<FieldError> errors = bindingResult.getFieldErrors();
//            for (FieldError error : errors) {
//                log.info("Field: {}", error.getField());
//                log.info("Field: {}", error.getDefaultMessage());
//            }
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getClass().getName());
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                log.error("????????? ?????????" + error.getField());
                log.error("????????? ????????? ???" + (String) error.getRejectedValue());
                log.error("????????? ???????????? ????????????" + error.getDefaultMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getClass().getName());
    }
}
