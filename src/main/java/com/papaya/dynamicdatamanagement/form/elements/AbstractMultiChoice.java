package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;

import java.util.List;
public abstract class AbstractMultiChoice<T> extends AbstractInputField<List<T>> {
    private List<T> choices;

    private String choiceLabel;

    public void setChoices(List<T> choices) {
        this.choices = choices;
    }

    public void setChoiceLabel(String choiceLabel) {
        this.choiceLabel = choiceLabel;
    }

    public List<T> getChoices() {
        return this.choices;
    }

    public String getChoiceLabel() {
        return this.choiceLabel;
    }

    public AbstractMultiChoice(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, Binding<List<T>> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<List<T>>> fieldValidators, List<T> userInput, List<T> choices, String choiceLabel) {
        super(id, htmlId, index, parentSection, discarded, visible, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
        this.choices = choices;
        this.choiceLabel = choiceLabel;
    }
}
