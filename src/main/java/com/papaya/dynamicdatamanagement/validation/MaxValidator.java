package com.papaya.dynamicdatamanagement.validation;

import com.papaya.dynamicdatamanagement.model.elements.AbstractInputField;

public class MaxValidator implements FieldValidator<Integer> {
    private int max;
    private String message;
    @Override
    public void validate(AbstractInputField<Integer> inputField, Integer value, ValidationFeedback feedback) {
        if (inputField.getUserInput() > max) {
            feedback.error(message);
        }
    }
}
