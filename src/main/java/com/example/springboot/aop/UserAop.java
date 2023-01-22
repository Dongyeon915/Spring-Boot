package com.example.springboot.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAop {

//    @Pointcut("execution(* com.example.springboot.controller..*.*(..))")
//    public void aopRange() {
//
//    }

//    //    Pointcut을 패키지 excution으로 지정하지 않고 어노테이션을 명시해서 사용할때는 Pointcut변경 필요
//    @Pointcut("@annotation(UserAnotation)")
//    public void aopAnotation() {
//    }

//    @Before("aopRange()")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("[Before]");
//        Object[] objects = joinPoint.getArgs();
//        for (Object a : objects) {
//            System.out.println(a.getClass());
//        }
//        System.out.println("비포 클래스 확인 완료");
//    }

//    @AfterReturning(value = "aopRange()", returning = "obj")
//    public Object after(JoinPoint joinPoint, Object obj) {
//        if (obj instanceof UserDto) {
//            UserDto user = (UserDto) obj;
//            System.out.println("[AfterReturning]");
//            return obj;
//        }
//        return obj;
//    }
}
