package com.papaya.dynamicdatamanagement.validation;

import com.papaya.dynamicdatamanagement.model.elements.AbstractInputField;

public interface FieldValidator<T> {
    void validate(final AbstractInputField<T> inputField, final T value, final ValidationFeedback feedback);
}
