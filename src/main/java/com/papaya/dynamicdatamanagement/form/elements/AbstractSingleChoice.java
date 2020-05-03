package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.validation.FieldValidator;

import java.util.List;

public abstract class   AbstractSingleChoice<T> extends AbstractInputField<T> {
    protected List<T> choices;

    private String choiceLabel;

    private Class<T> modelClass;

    public AbstractSingleChoice() {

    }

    public List<T> getChoices() {
        return choices;
    }

    public void setChoices(List<T> choices) {
        this.choices = choices;
    }

    public String getChoiceLabel() {
        return choiceLabel;
    }

    public void setChoiceLabel(String choiceLabel) {
        this.choiceLabel = choiceLabel;
    }

    @Override
    public Class<T> getModelClass() {
        return modelClass;
    }

    public void setModelClass(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    public AbstractSingleChoice(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<T> binding, String label, String hint, boolean required, boolean enabled, String requiredMessage, List<FieldValidator<T>> fieldValidators, T userInput, List<T> choices, String choiceLabel, Class<T> modelClass) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding, label, hint, required, enabled, requiredMessage, fieldValidators, userInput);
        this.choices = choices;
        this.choiceLabel = choiceLabel;
        this.modelClass = modelClass;
    }
}
