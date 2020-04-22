package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.InputType;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.Builder;

import java.util.List;

public class IntegerTextField extends TextField<Integer> {
    @Builder(builderMethodName = "innerBuilder")
    public IntegerTextField(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<Integer> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<Integer>> fieldValidators, Integer userInput, String placeholder, Class<Integer> modelClass) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput, placeholder, modelClass);
    }

    @Override
    public InputType getInputType() {
        return InputType.INTEGER_INPUT;
    }

    @Override
    public Class<Integer> getModelClass() {
        return Integer.class;
    }
}
