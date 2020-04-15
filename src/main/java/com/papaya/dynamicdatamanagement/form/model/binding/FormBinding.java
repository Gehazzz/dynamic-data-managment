package com.papaya.dynamicdatamanagement.form.model.binding;

import com.papaya.dynamicdatamanagement.form.model.elements.main.Form;

import java.util.Map;
//TODO delete class
public class FormBinding implements Binding<Map<String, Binding<?>>> {
    private Form form;
    private Map<String, Binding<?>> values;

    @Override
    public void setValue(Map<String, Binding<?>> value) {
        this.values = value;
    }

    @Override
    public Map<String, Binding<?>> getValue() {
        return values;
    }

    public Binding<?> getValueByKey(String key) {
        return this.values.get(key);
    }
}
