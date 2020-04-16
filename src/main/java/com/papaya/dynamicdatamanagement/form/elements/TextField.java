package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.Builder;

import java.util.List;

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

    @Builder
    public TextField(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, Binding<T> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<T>> fieldValidators, T userInput, String placeholder, Class<T> modelClass) {
        super(id, htmlId, index, parentSection, discarded, visible, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
        this.placeholder = placeholder;
        this.modelClass = modelClass;
    }
}
