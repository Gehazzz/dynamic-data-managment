package com.papaya.dynamicdatamanagement.validation;

import com.papaya.dynamicdatamanagement.model.elements.AbstractInputField;
import com.papaya.dynamicdatamanagement.model.elements.main.Form;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.stream.Collectors;

public class DynamicFormValidator implements ConstraintValidator<ValidForm, Form> {
    @Override
    public boolean isValid(Form form, ConstraintValidatorContext constraintValidatorContext) {
        List<ConstraintViolation> violations = form.getValidators()
                .stream()
                .flatMap(validator -> validator.validate(form).stream())
                .collect(Collectors.toList());

        violations.addAll(form.getMainSection().getValidators()
                .stream()
                .flatMap(validator -> validator.validate(form.getMainSection()).stream())
                .collect(Collectors.toList()));
        List<AbstractInputField<?>> inputFields = form.getMainSection().getInputFields();
       /* for (AbstractInputField<?> inputField : inputFields) {


            inputField.getValidators();


            inputField.getValidators()
                    .stream()
                    .flatMap(validator->{
                        Type[] types = ((ParameterizedType) inputField).getActualTypeArguments();

                        validator.validate(inputField).stream()
                    })

        }*/
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate("message -1").addConstraintViolation();
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate("message -2").addConstraintViolation();
        return false;
    }
}
