package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.InputType;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;


@AllArgsConstructor
public class FileInput extends  AbstractInputField<Byte[]>{
    @Override
    public InputType getInputType() {
        return InputType.FILE_INPUT;
    }
    @Builder
    public FileInput(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<Byte[]> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<Byte[]>> fieldValidators, Byte[] userInput) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
    }
}
