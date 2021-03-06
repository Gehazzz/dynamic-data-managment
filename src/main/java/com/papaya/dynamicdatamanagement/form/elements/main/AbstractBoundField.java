package com.papaya.dynamicdatamanagement.form.elements.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.papaya.dynamicdatamanagement.form.binding.Binding;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
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

    public AbstractBoundField(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<T> binding) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton);
        this.binding = binding;
    }
}
