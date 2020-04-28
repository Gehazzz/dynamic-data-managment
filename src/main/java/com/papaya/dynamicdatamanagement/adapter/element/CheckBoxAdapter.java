package com.papaya.dynamicdatamanagement.adapter.element;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.form.validation.BooleanValidator;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;
import com.papaya.dynamicdatamanagement.repository.model.CheckboxDetails;
import com.papaya.dynamicdatamanagement.repository.model.ValidationRule;
import com.papaya.dynamicdatamanagement.form.elements.Checkbox;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckBoxAdapter
{

    private ObjectMapper objectMapper = new ObjectMapper();

    public Checkbox mapToServiceEntity(CheckboxDetails checkboxDetails) {

       return Checkbox.builder()
                .id(checkboxDetails.getId())
                .discarded(checkboxDetails.isDiscarded())
                .enabled(checkboxDetails.isEnabled())
                .hint(checkboxDetails.getHint())
                .label(checkboxDetails.getLabel())
                .requiredMessage(checkboxDetails.getRequiredMessage())
                .required(checkboxDetails.isRequired())
                .fieldValidators(getValidators(checkboxDetails.getValidationRules())).build();
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

    public CheckboxDetails mapToDataEntity(Checkbox abstractFormElement) {
        Checkbox checkbox = objectMapper.convertValue(abstractFormElement, Checkbox.class);

        return CheckboxDetails.builder().validationRules(getValidationRules(checkbox.getValidators())).build();
    }




}
