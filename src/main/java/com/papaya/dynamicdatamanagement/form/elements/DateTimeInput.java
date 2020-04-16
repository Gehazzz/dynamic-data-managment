package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;


public class DateTimeInput extends AbstractInputField<LocalDateTime> {
    DateTimeInput() {
    }

    @Builder
    public DateTimeInput(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<LocalDateTime> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<LocalDateTime>> fieldValidators, LocalDateTime userInput) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
    }
}
