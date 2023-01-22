package com.example.springboot.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 적용할 위치
@Target({ElementType.FIELD,ElementType.METHOD})
// 런타임시 적용
@Retention(RetentionPolicy.RUNTIME)
// @추가
public @interface UserAnotation {

}
