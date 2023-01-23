package com.example.springboot.aop;

import com.example.springboot.dto.UserDto;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAop {

    @Pointcut("execution(* com.example.springboot.controller..*.*(..))")
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
            System.out.println(a);
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

    @AfterReturning(value = "aopRange()", returning = "obj")
    public Object myencoder(JoinPoint joinPoint, Object obj) {
        if (obj instanceof UserDto) {
            UserDto dto = (UserDto) obj;
            String encoding = new String(
                Base64.getEncoder().encode(dto.getName().getBytes(StandardCharsets.UTF_8)));
            dto.setName(encoding);
        }
        return obj;
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

