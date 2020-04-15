package com.papaya.dynamicdatamanagement.service.form.model.elements;

public class StringTextField extends TextField<String> {
    @Override
    public Class<String> getModelClass() {
        return String.class;
    }
}
