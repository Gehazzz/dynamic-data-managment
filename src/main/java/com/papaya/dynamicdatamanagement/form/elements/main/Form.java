package com.papaya.dynamicdatamanagement.form.elements.main;

import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import com.papaya.dynamicdatamanagement.form.validation.FormValidator;
import com.papaya.dynamicdatamanagement.form.validation.ValidForm;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
@ValidForm
public class Form {

    Long id;

    private Section mainSection;

    private ArrayList<FormValidator> validators;

    private String label;

    private UsageLevel usageLevel;


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

    public Form() {
    }
    @Builder
    public Form(Long id, Section mainSection, ArrayList<FormValidator> validators, String label, UsageLevel usageLevel) {
        this.id = id;
        this.mainSection = mainSection;
        this.validators = validators;
        this.label = label;
        this.usageLevel = usageLevel;
    }
}
