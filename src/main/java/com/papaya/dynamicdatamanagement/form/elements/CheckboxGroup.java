package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

public class CheckboxGroup<T> extends AbstractMultiChoice<T> {

    @Builder
    public CheckboxGroup(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, Binding<List<T>> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<List<T>>> fieldValidators, List<T> userInput, List<T> choices, String choiceLabel) {
        super(id, htmlId, index, parentSection, discarded, visible, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput, choices, choiceLabel);
    }
}
