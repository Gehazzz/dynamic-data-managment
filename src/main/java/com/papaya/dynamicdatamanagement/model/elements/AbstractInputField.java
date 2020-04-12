package com.papaya.dynamicdatamanagement.model.elements;

import com.papaya.dynamicdatamanagement.model.elements.main.AbstractBoundField;
import com.papaya.dynamicdatamanagement.validation.FieldValidator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInputField<T> extends AbstractBoundField<T> {
    private String label;

    private String hint;

    private boolean required = false;

    private boolean enabled = true;

    private String requiredMessage;

    private List<FieldValidator<T>> validators = new ArrayList<FieldValidator<T>>();

    private T userInput;

    public AbstractInputField<T> setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getLabel() {
        return this.label;
    }

    public AbstractInputField<T> add(FieldValidator<T> validator) {
        this.getValidators().add(validator);
        return this;
    }

    public AbstractInputField<T> setHint(final String hint) {
        this.hint = hint;
        return this;
    }

    public String getHint() {
        return this.hint;
    }

    public AbstractInputField<T> setRequired(final boolean required) {
        this.required = required;
        return this;
    }

    public boolean isRequired() {
        return this.required;
    }

    public AbstractInputField<T> setRequiredMessage(final String requiredMessage) {
        this.requiredMessage = requiredMessage;
        return this;
    }

    public String getRequiredMessage() {
        return this.requiredMessage;
    }

    public List<FieldValidator<T>> getValidators() {
        return this.validators;
    }

    public void setUserInput(final T userInput) {
        this.userInput = userInput;
    }

    public T getUserInput() {
        return this.userInput;
    }

    public AbstractInputField<T> setEnabled(final boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public Class<?> getModelClass() {
        return Object.class;
    }
}
