package com.papaya.dynamicdatamanagement.service.form.model.elements;

import com.papaya.dynamicdatamanagement.service.form.model.binding.Binding;
import com.papaya.dynamicdatamanagement.service.form.model.elements.main.Section;
import com.papaya.dynamicdatamanagement.service.form.validation.FieldValidator;

import java.util.List;


public class Checkbox extends AbstractInputField<Boolean> {
    public static CheckboxBuilder builder() {
        return new CheckboxBuilder();
    }

    @Override
    public Class<?> getModelClass() {
        return Boolean.class;
    }

    public Checkbox(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, Binding<Boolean> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<Boolean>> fieldValidators, Boolean userInput) {
        super(id, htmlId, index, parentSection, discarded, visible, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
    }

    public static class CheckboxBuilder {
        private Long id;
        private String htmlId;
        private Integer index;
        private Section parentSection;
        private boolean discarded;
        private boolean visible;
        private Binding<Boolean> binding;
        private String label;
        private String hint;
        private boolean required;
        private boolean enabled;
        private String requiredMessage;
        private List<FieldValidator<Boolean>> fieldValidators;
        private Boolean userInput;

        CheckboxBuilder() {
        }

        public CheckboxBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CheckboxBuilder htmlId(String htmlId) {
            this.htmlId = htmlId;
            return this;
        }

        public CheckboxBuilder index(Integer index) {
            this.index = index;
            return this;
        }

        public CheckboxBuilder parentSection(Section parentSection) {
            this.parentSection = parentSection;
            return this;
        }

        public CheckboxBuilder discarded(boolean discarded) {
            this.discarded = discarded;
            return this;
        }

        public CheckboxBuilder visible(boolean visible) {
            this.visible = visible;
            return this;
        }

        public CheckboxBuilder binding(Binding<Boolean> binding) {
            this.binding = binding;
            return this;
        }

        public CheckboxBuilder label(String label) {
            this.label = label;
            return this;
        }

        public CheckboxBuilder hint(String hint) {
            this.hint = hint;
            return this;
        }

        public CheckboxBuilder required(boolean required) {
            this.required = required;
            return this;
        }

        public CheckboxBuilder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public CheckboxBuilder requiredMessage(String requiredMessage) {
            this.requiredMessage = requiredMessage;
            return this;
        }

        public CheckboxBuilder fieldValidators(List<FieldValidator<Boolean>> fieldValidators) {
            this.fieldValidators = fieldValidators;
            return this;
        }

        public CheckboxBuilder userInput(Boolean userInput) {
            this.userInput = userInput;
            return this;
        }

        public Checkbox build() {
            return new Checkbox(id, htmlId, index, parentSection, discarded, visible, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
        }

        public String toString() {
            return "Checkbox.CheckboxBuilder(id=" + this.id + ", htmlId=" + this.htmlId + ", index=" + this.index + ", parentSection=" + this.parentSection + ", discarded=" + this.discarded + ", visible=" + this.visible + ", binding=" + this.binding + ", label=" + this.label + ", hint=" + this.hint + ", required=" + this.required + ", enabled=" + this.enabled + ", requiredMessage=" + this.requiredMessage + ", fieldValidators=" + this.fieldValidators + ", userInput=" + this.userInput + ")";
        }
    }
}
