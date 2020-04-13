package com.papaya.dynamicdatamanagement.validation;

import com.papaya.dynamicdatamanagement.model.elements.AbstractInputField;

import java.util.Collections;
import java.util.Set;

public class MaxValidator implements FieldValidator<Integer> {
    private int max;
    private String message;
    @Override
    public Set<String> validate(AbstractInputField<Integer> inputField) {
        if (inputField.getUserInput() > max) {
            return Set.of(message);
        }
        return Collections.emptySet();
    }
}
