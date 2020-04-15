package com.papaya.dynamicdatamanagement.service.form.validation;

import com.papaya.dynamicdatamanagement.service.form.model.elements.AbstractInputField;

import java.util.Set;

public interface FieldValidator<T> {
    Set<String> validate(final AbstractInputField<T> inputField);
}
