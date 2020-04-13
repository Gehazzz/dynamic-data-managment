package com.papaya.dynamicdatamanagement.validation;

import com.papaya.dynamicdatamanagement.model.elements.AbstractInputField;

public class MinValidator implements FieldValidator<Integer>{
    private int min;
    private String message;
    @Override
    public void validate(AbstractInputField<Integer> inputField, Integer value, ValidationFeedback feedback) {
        if (inputField.getUserInput() < min) {
            feedback.error(message);
        }
    }
}
