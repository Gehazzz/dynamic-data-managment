package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.Builder;

import java.util.List;

public class DoubleTextField extends TextField<Double>{

    @Builder
    public DoubleTextField(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<Double> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<Double>> fieldValidators, Double userInput, String placeholder, Class<Double> modelClass) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput, placeholder, modelClass);
    }

    @Override
    public Class<Double> getModelClass() {
        return Double.class;
    }
}