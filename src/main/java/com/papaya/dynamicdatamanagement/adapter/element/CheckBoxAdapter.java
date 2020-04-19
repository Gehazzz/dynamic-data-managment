package com.papaya.dynamicdatamanagement.adapter.element;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.form.validation.BooleanValidator;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import com.papaya.dynamicdatamanagement.repository.model.template.*;
import com.papaya.dynamicdatamanagement.form.elements.Checkbox;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckBoxAdapter
{

    private ObjectMapper objectMapper = new ObjectMapper();

    public Checkbox mapToServiceEntity(CheckboxTemplate checkboxTemplate) {

       return Checkbox.builder()
                .id(checkboxTemplate.getId())
                .discarded(checkboxTemplate.isDiscarded())
                .enabled(checkboxTemplate.isEnabled())
                .hint(checkboxTemplate.getHint())
                .label(checkboxTemplate.getLabel())
                .requiredMessage(checkboxTemplate.getRequiredMessage())
                .required(checkboxTemplate.isRequired())
                .fieldValidators(getValidators(checkboxTemplate.getValidationRules())).build();
    }

    public List<FieldValidator<Boolean>> getValidators(List<ValidationRule> fieldValidators){
        List<FieldValidator<Boolean>> outputValidatorsList= new ArrayList<>();
        for (ValidationRule rule: fieldValidators) {
            BooleanValidator booleanValidator = BooleanValidator.builder().message(rule.getMessage()).data(Boolean.parseBoolean(rule.getData())).build();
            outputValidatorsList.add(booleanValidator);
        }
        return outputValidatorsList;
    }

    public List<ValidationRule> getValidationRules(List<FieldValidator<Boolean>> fieldValidators){
        List<ValidationRule> validationRules = new ArrayList<>();
        for (FieldValidator<Boolean> fieldValidator : fieldValidators) {
            BooleanValidator booleanValidator = objectMapper.convertValue(fieldValidator, BooleanValidator.class);
            validationRules.add(ValidationRule.builder().message(booleanValidator.getMessage()).data(booleanValidator.getData().toString()).build());
        }
        return validationRules;
    }

    public CheckboxTemplate mapToDataEntity(Checkbox abstractFormElement) {
        Checkbox checkbox = objectMapper.convertValue(abstractFormElement, Checkbox.class);

        return CheckboxTemplate.builder().validationRules(getValidationRules(checkbox.getValidators())).build();
    }




}
