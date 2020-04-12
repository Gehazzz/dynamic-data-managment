package com.papaya.dynamicdatamanagement.model.binding;

public interface Binding<T> {
    void setValue(T value);

    T getValue();
}
