package com.papaya.dynamicdatamanagement.form.validation;

import com.papaya.dynamicdatamanagement.form.elements.AbstractInputField;
import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO separate form, section and inputs validations
public class DynamicFormValidator implements ConstraintValidator<ValidForm, Form> {
    @Override
    public boolean isValid(Form form, ConstraintValidatorContext constraintValidatorContext) {
        List<String> violations = form.validateAndGetViolations();
        fillSectionViolationsRecursively(form.getMainSection(), violations);

     /*   violations.addAll(form.getMainSection().getValidators()
                .stream()
                .flatMap(validator -> validator.validate(form.getMainSection()).stream())
                .collect(Collectors.toList()));
*/

       /* violations.addAll(form.getMainSection().getInputFields()
                .stream()
                .flatMap(inputField -> {
                    List<String> list = inputField.validateAndGetViolations();
                    return list.stream();
                })
                .collect(Collectors.toList()));
*/
/*

        violations.addAll(form.getMainSection().getInputFields()
                .stream()
                .flatMap(inputField -> inputField.validateAndGetViolations().stream())
                .collect(Collectors.toList()));
*/

        constraintValidatorContext.disableDefaultConstraintViolation();
        violations.forEach(violation -> constraintValidatorContext.buildConstraintViolationWithTemplate(violation).addConstraintViolation());
        return false;
    }

    private void fillSectionViolationsRecursively(Section section, List<String> violations) {
        violations.addAll(section.validateAndGetViolations());
        violations.addAll(section.getInputFields()
                .stream()
                //TODO inputField validators, call validate method here and not in the inputField class!!!
                .flatMap(AbstractInputField::validateAndGetViolations)
                .collect(Collectors.toList()));

        List<Section> embeddedSections = section.getEmbeddedSections();
        if (embeddedSections != null && !embeddedSections.isEmpty()) {
            for (Section embeddedSection : embeddedSections) {
                fillSectionViolationsRecursively(embeddedSection, violations);
            }
        }
    }

}
