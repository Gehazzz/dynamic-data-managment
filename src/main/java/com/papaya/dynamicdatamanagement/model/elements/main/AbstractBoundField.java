package com.papaya.dynamicdatamanagement.model.elements.main;

import com.papaya.dynamicdatamanagement.model.binding.Binding;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class AbstractBoundField<T> extends AbstractFormElement {
    private Binding<T> binding;

    public T getValue() {
        return getBinding().getValue();
    }

    public AbstractBoundField<T> setValue(final T value) {
        getBinding().setValue(value);
        return this;
    }

    public Binding<T> getBinding() {
        return this.binding;
    }

    public AbstractBoundField<T> setBinding(final Binding<T> binding) {
        this.binding = binding;
        return this;
    }
}
