package com.papaya.dynamicdatamanagement.validation;

import com.papaya.dynamicdatamanagement.model.elements.AbstractInputField;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface FieldValidator<T> {
    Set<ConstraintViolation<AbstractInputField<T>>> validate(final AbstractInputField<T> inputField);
}
