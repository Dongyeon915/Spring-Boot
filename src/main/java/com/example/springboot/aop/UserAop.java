package com.example.springboot.aop;

import com.example.springboot.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

    @Before("aopRange()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Before]");
        Object[] objects = joinPoint.getArgs();
        for (Object a : objects) {
            System.out.println(a.getClass());
        }
        System.out.println("비포 클래스 확인 완료");
    }

    @AfterReturning(value = "aopRange()", returning = "obj")
    public Object after(JoinPoint joinPoint, Object obj) {
        if (obj instanceof UserDto) {
            System.out.println("[AfterReturning]");
            return obj;
        }
        return obj;
    }
}
