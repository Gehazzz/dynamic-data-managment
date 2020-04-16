package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.Builder;

import java.util.List;


public class Checkbox extends AbstractInputField<Boolean> {

    @Override
    public Class<?> getModelClass() {
        return Boolean.class;
    }

    @Builder
    public Checkbox(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<Boolean> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<Boolean>> fieldValidators, Boolean userInput) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
    }

}
