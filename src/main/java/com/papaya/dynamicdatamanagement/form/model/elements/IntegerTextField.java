package com.papaya.dynamicdatamanagement.form.model.elements;

public class IntegerTextField extends TextField<Integer> {
    @Override
    public Class<Integer> getModelClass() {
        return Integer.class;
    }
}
