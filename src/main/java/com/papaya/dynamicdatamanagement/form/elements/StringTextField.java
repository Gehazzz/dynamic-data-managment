package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.InputType;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.Builder;

import java.util.List;

public class StringTextField extends TextField<String> {

    @Builder(builderMethodName = "innerBuilder")
    public StringTextField(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<String> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<String>> fieldValidators, String userInput, String placeholder, Class<String> modelClass) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput, placeholder, modelClass);
    }

    @Override
    public InputType getInputType() {
        return InputType.STRING_INPUT;
    }

    @Override
    public Class<String> getModelClass() {
        return String.class;
    }
}
