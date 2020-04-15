package com.papaya.dynamicdatamanagement.form.elements;

public class StringTextField extends TextField<String> {
    @Override
    public Class<String> getModelClass() {
        return String.class;
    }
}
