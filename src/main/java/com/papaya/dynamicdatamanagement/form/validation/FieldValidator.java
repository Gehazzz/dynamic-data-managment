package com.papaya.dynamicdatamanagement.form.validation;

import com.papaya.dynamicdatamanagement.form.model.elements.AbstractInputField;

import java.util.Set;

public interface FieldValidator<T> {
    Set<String> validate(final AbstractInputField<T> inputField);
}
