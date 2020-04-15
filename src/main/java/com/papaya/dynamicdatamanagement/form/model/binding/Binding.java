package com.papaya.dynamicdatamanagement.form.model.binding;

public interface Binding<T> {
    void setValue(T value);

    T getValue();
}
