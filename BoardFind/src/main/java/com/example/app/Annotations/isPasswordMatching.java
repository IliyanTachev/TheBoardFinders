package com.example.app.Annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = isPasswordMatchingValidator.class)
public @interface isPasswordMatching {
    String message() default "Passwords Not Matching";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
