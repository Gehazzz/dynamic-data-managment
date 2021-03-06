package com.papaya.dynamicdatamanagement.form.elements.main;

import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import com.papaya.dynamicdatamanagement.form.validation.FormValidator;
import com.papaya.dynamicdatamanagement.form.validation.ValidForm;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ValidForm
public class Form {

    Long id;

    Form template;

    private Section mainSection;

    private ArrayList<FormValidator> validators;

    private String label;

    private FormType formType;

    private FormSubType formSubType;

    private List<UsageLevel> usageLevels;

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Form getTemplate() {
        return template;
    }

    public FormType getFormType() {
        return formType;
    }

    public FormSubType getFormSubType() {
        return formSubType;
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

    public List<String> validateAndGetViolations() {
        return validators.stream().flatMap(validator -> validator.validate(this).stream())
                .collect(Collectors.toList());
    }

    public Section getMainSection() {
        return mainSection;
    }

    public Form() {
    }

    @Builder
    public Form(Long id, Form template, Section mainSection, ArrayList<FormValidator> validators, String label, FormType formType, FormSubType formSubType, List<UsageLevel> usageLevels) {
        this.id = id;
        this.template = template;
        this.mainSection = mainSection;
        this.validators = validators;
        this.label = label;
        this.formType = formType;
        this.formSubType = formSubType;
        this.usageLevels = usageLevels;
    }
}
