package com.example.demo.exception;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePeakName {

    Class<?>[] groups() default {};

    String message() default "Peak name must be unique";

    Class<? extends Payload>[] payload() default {};

}
