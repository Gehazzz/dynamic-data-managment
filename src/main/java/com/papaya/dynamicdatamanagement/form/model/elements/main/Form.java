package com.papaya.dynamicdatamanagement.form.model.elements.main;

import com.papaya.dynamicdatamanagement.form.model.usage.UsageLevel;
import com.papaya.dynamicdatamanagement.form.validation.FormValidator;
import com.papaya.dynamicdatamanagement.form.validation.ValidForm;

import java.util.ArrayList;
import java.util.List;
/*@Builder*/
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
}
