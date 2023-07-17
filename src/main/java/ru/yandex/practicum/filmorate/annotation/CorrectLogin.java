package ru.yandex.practicum.filmorate.annotation;

import ru.yandex.practicum.filmorate.validator.LoginValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = LoginValidator.class)

public @interface CorrectLogin {
    String message() default "Must not have space";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

