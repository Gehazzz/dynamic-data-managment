package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.InputType;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.Builder;

import java.util.List;

public class TextArea extends AbstractInputField<String> {
    private String placeholder;

    @java.beans.ConstructorProperties({"placeholder"})
    TextArea(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public InputType getInputType() {
        return InputType.TEXT_AREA;
    }

    @Override
    public Class<?> getModelClass() {
        return String.class;
    }

    @Builder
    public TextArea(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<String> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<String>> fieldValidators, String userInput, String placeholder) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
        this.placeholder = placeholder;
    }
}
