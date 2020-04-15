package com.papaya.dynamicdatamanagement.form.validation;

import com.papaya.dynamicdatamanagement.form.model.elements.AbstractInputField;

import java.util.Collections;
import java.util.Set;

public class MinValidator implements FieldValidator<Integer>{
    private int min;
    private String message;

    @Override
    public Set<String> validate(AbstractInputField<Integer> inputField) {
        if (inputField.getUserInput() < min) {
            return Set.of(message);
        }
        return Collections.emptySet();
    }
}
