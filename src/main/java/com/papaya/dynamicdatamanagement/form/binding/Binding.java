package com.papaya.dynamicdatamanagement.form.binding;

public interface Binding<T> {
    void setValue(T value);

    T getValue();
}
