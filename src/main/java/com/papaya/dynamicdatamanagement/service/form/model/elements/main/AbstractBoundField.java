package com.papaya.dynamicdatamanagement.service.form.model.elements.main;

import com.papaya.dynamicdatamanagement.service.form.model.binding.Binding;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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

    public AbstractBoundField(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, Binding<T> binding) {
        super(id, htmlId, index, parentSection, discarded, visible);
        this.binding = binding;
    }
}
