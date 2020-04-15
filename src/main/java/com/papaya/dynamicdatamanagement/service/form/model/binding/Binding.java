package com.papaya.dynamicdatamanagement.service.form.model.binding;

public interface Binding<T> {
    void setValue(T value);

    T getValue();
}
