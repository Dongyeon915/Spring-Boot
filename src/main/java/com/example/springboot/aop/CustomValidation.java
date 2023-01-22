package com.example.springboot.aop;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {CustomValidationClass.class})
public @interface CustomValidation {

    //   ConstraintHelper가 확인하는 필드 이므로 필수적인 3개
    //  특정 Validation의 Group을 지정
    Class<?>[] groups() default {};

    //  Validation이 실패할 경우 반환되는 메세지
    String message() default "{테스트 확인}";

    // 사용자의 추가 정보를 전달할 수 있는 값으로 주로 심각도를 나탈낼 떄 사용
    Class<? extends Payload>[] payload() default {};

//    int min() default 0;
//
//    /**
//     * @return size the element must be lower or equal to
//     */
//    int max() default Integer.MAX_VALUE;
//
//    /**
//     * Defines several {@link Size} annotations on the same element.
//     *
//     * @see Size
//     */
//    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
//    @Retention(RUNTIME)
//    @Documented
//    @interface List {
//
//        Size[] value();
    }

