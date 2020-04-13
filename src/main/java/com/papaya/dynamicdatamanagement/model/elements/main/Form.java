package com.papaya.dynamicdatamanagement.model.elements.main;

import com.papaya.dynamicdatamanagement.validation.FormValidator;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@Builder
public class Form {

    Long id;

    private Section mainSection;

    private ArrayList<FormValidator> validators;

    private String label;

    public String getLabel() {
        return label;
    }

    public Form add(AbstractFormElement formElement) {
        getMainSection().add(formElement);
        return this;
    }

    public Form add(FormValidator validator) {
        validators.add(validator);
        return this;
    }

    public List<FormValidator> getValidators() {
        return validators;
    }

    public Section getMainSection() {
        return mainSection;
    }
}
