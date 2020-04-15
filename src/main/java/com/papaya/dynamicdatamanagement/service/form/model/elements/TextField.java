package com.papaya.dynamicdatamanagement.service.form.model.elements;
/**
 * A text field that may contain a string, any type that can
 * be represented as a string;
 */
public class TextField<T> extends AbstractInputField<T> {
    private String placeholder;

    private Class<T> modelClass;

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public Class<T> getModelClass() {
        return modelClass;
    }

    public void setModelClass(Class<T> modelClass) {
        this.modelClass = modelClass;
    }
}
