package com.papaya.dynamicdatamanagement.form.model.elements;

import java.util.List;

public abstract class   AbstractSingleChoice<T> extends AbstractInputField<T> {
    protected List<T> choices;

    private String choiceLabel;

    private Class<T> modelClass;

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
}
