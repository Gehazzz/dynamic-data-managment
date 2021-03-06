package com.papaya.dynamicdatamanagement.form.binding;

public class ValueBinding<T> implements Binding<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

}
