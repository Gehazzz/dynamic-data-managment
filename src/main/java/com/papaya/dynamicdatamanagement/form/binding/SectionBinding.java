package com.papaya.dynamicdatamanagement.form.binding;

import java.util.Map;

public class SectionBinding implements Binding<Map<String, Binding<?>>> {
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
