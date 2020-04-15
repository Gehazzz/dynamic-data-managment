package com.papaya.dynamicdatamanagement.service.form.model.elements;

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

}
