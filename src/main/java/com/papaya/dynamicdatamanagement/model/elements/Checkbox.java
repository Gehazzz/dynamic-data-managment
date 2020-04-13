package com.papaya.dynamicdatamanagement.model.elements;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Checkbox extends AbstractInputField<Boolean> {

    @Override
    public Class<?> getModelClass() {
        return Boolean.class;
    }

}
