package com.papaya.dynamicdatamanagement.form.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DynamicFormValidator.class)
@Documented
public @interface ValidForm {

    String message() default "{}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
