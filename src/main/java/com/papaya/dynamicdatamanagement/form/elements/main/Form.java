package com.papaya.dynamicdatamanagement.form.elements.main;

import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
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

    public static FormBuilder builder() {
        return new FormBuilder();
    }

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

    public Form(Long id, Section mainSection, ArrayList<FormValidator> validators, String label, UsageLevel usageLevel) {
        this.id = id;
        this.mainSection = mainSection;
        this.validators = validators;
        this.label = label;
        this.usageLevel = usageLevel;
    }

    public static class FormBuilder {
        private Long id;
        private Section mainSection;
        private ArrayList<FormValidator> validators;
        private String label;
        private UsageLevel usageLevel;

        FormBuilder() {
        }

        public FormBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FormBuilder mainSection(Section mainSection) {
            this.mainSection = mainSection;
            return this;
        }

        public FormBuilder validators(ArrayList<FormValidator> validators) {
            this.validators = validators;
            return this;
        }

        public FormBuilder label(String label) {
            this.label = label;
            return this;
        }

        public FormBuilder usageLevel(UsageLevel usageLevel) {
            this.usageLevel = usageLevel;
            return this;
        }

        public Form build() {
            return new Form(id, mainSection, validators, label, usageLevel);
        }

        public String toString() {
            return "Form.FormBuilder(id=" + this.id + ", mainSection=" + this.mainSection + ", validators=" + this.validators + ", label=" + this.label + ", usageLevel=" + this.usageLevel + ")";
        }
    }
}
