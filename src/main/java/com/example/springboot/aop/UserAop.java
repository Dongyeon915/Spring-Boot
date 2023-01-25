package com.example.springboot.aop;

import com.example.springboot.dto.ErrorDto;
import com.example.springboot.dto.UserDto;
import com.example.springboot.dto.UserResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Slf4j
@Aspect
@Component
public class UserAop {

    @Pointcut("execution(* com.example.springboot.controller.UserController.*(..))")
    public void aopRange() {

    }

//    //    Pointcut을 패키지 excution으로 지정하지 않고 어노테이션을 명시해서 사용할때는 Pointcut변경 필요
//    @Pointcut("@annotation(UserAnotation)")
//    public void aopAnotation() {
//    }

    @Before("aopRange()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Before]");
        Object[] objects = joinPoint.getArgs();
        for (Object a : objects) {
            if (a instanceof UserDto) {
                /*UserDto user = (UserDto) a;
                String decodeName = new String(Base64.getDecoder().decode(user.getName()));
                String decodeAge = new String(Base64.getDecoder().decode(user.getAgeStr()));
                Integer age = Integer.valueOf(decodeAge);
                user.setName(decodeName);
                user.setAge(age);*/
            }
        }
    }

//    @AfterReturning(value = "aopRange()", returning = "obj")
//    public Object after(JoinPoint joinPoint, Object obj) {
//        if (obj instanceof UserDto) {
//            UserDto user = (UserDto) obj;
//            System.out.println("[AfterReturning]");
//            return obj;
//        }
//        return obj;
//    }





    // after리터닝은 컨트롤러에서 리턴된 값이 나한테 들어옴
// 리턴값을 주고싶을때는 around로 해줘야한다.
    @Around(value = "aopRange()")
    public Object myencoder(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
            Object[] args = joinPoint.getArgs();
            BindingResult bindingResult = null;
            UserDto user = null;
            for (Object obj : args) {
                if (obj instanceof UserDto) {
                    user = (UserDto) obj;
                } else if (obj instanceof BindingResult) {
                    bindingResult = (BindingResult) obj;
                }
            }
            if (bindingResult != null && bindingResult.hasErrors()) {
                List<FieldError> errors = bindingResult.getFieldErrors();
                List<ErrorDto> errorList = new ArrayList<>();
                for (FieldError error : errors) {
                    ErrorDto errorDto = new ErrorDto();
                    errorDto.setFiled(error.getField());
                    errorDto.setMessage(error.getRejectedValue().toString());
                    errorDto.setRejectedValue(error.getDefaultMessage());
                    errorList.add(errorDto);
                }
                return errorList;
            } else {
                UserResponse response = new UserResponse();
                String encodingName = new String(Base64.getEncoder().encode(user.getName().getBytes(StandardCharsets.UTF_8)));
                String age = "" + user.getAge();
                String encodingAge = new String(Base64.getEncoder().encodeToString(age.getBytes()));
                response.setName(encodingName);
                response.setAgeStr(encodingAge);
                log.info("name: {}, age: {}", encodingName, encodingAge);
                return response;
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @AfterThrowing(pointcut = "aopRange()", throwing = "exception")
    public void test(Throwable exception) {
        log.error("AfterThrowing - {}", exception.getClass().getName());
    }



//    @Around("aopRange()")
//    public void responseAround(ProceedingJoinPoint joinPoint){
//       Object[] objects = joinPoint.getArgs();
//       for (Object arg : objects){
//           if (arg instanceof BindingResult){
//              BindingResult bindingResult = (BindingResult)arg;
//             List<FieldError> eroorList = bindingResult.getFieldErrors();
//             for(FieldError a : eroorList){

//                 System.out.println(a.getField());
//                 System.out.println(a.getDefaultMessage());
//                 System.out.println(a.getCode());
//             }
//             return;
//           }
//       }
//}

//    @AfterReturning(value = "aopRange()",returning = "obj")
//    public Object setInfoKind(JoinPoint joinPoint,Object obj){
//        if (obj instanceof UserDto){
//            UserDto userDto = (UserDto) obj;
//            String name = new String(Base64.getEncoder().encode(userDto.getName().getBytes(StandardCharsets.UTF_8)));
//            userDto.setName(name);
//        }
//        return obj;
//    }
}

