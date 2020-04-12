package com.papaya.dynamicdatamanagement.model.elements;

public class TextArea extends AbstractInputField<String> {
    private String placeholder;

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public Class<?> getModelClass() {
        return String.class;
    }
}
