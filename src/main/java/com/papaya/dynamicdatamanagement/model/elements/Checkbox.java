package com.papaya.dynamicdatamanagement.model.elements;

public class Checkbox extends AbstractInputField<Boolean> {

    @Override
    public Class<?> getModelClass() {
        return Boolean.class;
    }

}
