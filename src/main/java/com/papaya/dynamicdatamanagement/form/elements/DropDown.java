package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.Builder;

import java.util.List;

public class DropDown<T> extends AbstractSingleChoice<T> {

    @Builder
    public DropDown(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, Binding<T> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<T>> fieldValidators, T userInput, List<T> choices, String choiceLabel, Class<T> modelClass) {
        super(id, htmlId, index, parentSection, discarded, visible, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput, choices, choiceLabel, modelClass);
    }
}
