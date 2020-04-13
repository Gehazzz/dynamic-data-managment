package com.papaya.dynamicdatamanagement.validation;

import com.papaya.dynamicdatamanagement.model.elements.main.Form;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DynamicFormValidator implements ConstraintValidator<ValidForm, Form> {
    @Override
    public boolean isValid(Form form, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate("message -1").addConstraintViolation();
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate("message -2").addConstraintViolation();
        return false;
    }
}
