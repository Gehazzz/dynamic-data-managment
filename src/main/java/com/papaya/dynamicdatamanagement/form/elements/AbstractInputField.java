package com.papaya.dynamicdatamanagement.form.elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.AbstractBoundField;
import com.papaya.dynamicdatamanagement.form.elements.main.InputType;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "value", "parentSection" })
public abstract class AbstractInputField<T> extends AbstractBoundField<T> {
    private String label;

    private String hint;

    private boolean required = false;

    private boolean enabled = true;

    private String requiredMessage;

    public AbstractInputField(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<T> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<T>> validators, T userInput) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding);
        this.label = label;
        this.hint = hint;
        this.required = required;
        this.enabled = enabled;
        this.requiredMessage = requiredMessage;
        this.validators = validators;
        this.userInput = userInput;
    }

    private List<FieldValidator<T>> validators = new ArrayList<>();

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

    public abstract InputType getInputType();

    public Stream<String> validateAndGetViolations() {
        return validators.stream().flatMap(validator -> validator.validate(this).stream());
    }
}
