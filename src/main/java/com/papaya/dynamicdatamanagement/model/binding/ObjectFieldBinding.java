package com.papaya.dynamicdatamanagement.model.binding;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class ObjectFieldBinding<T> implements Binding<T>{
    private Object boundObject;

    private String property;

    public Object getBoundObject() {
        return boundObject;
    }

    public void setBoundObject(Object boundObject) {
        this.boundObject = boundObject;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }


    @Override
    //TODO: throw exception if field is null
    public void setValue(T value) {
        Field field = ReflectionUtils.findField(boundObject.getClass(), property);
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, boundObject, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    //TODO: throw exception if field is null
    public T getValue() {
        Field field = ReflectionUtils.findField(boundObject.getClass(), property);
        return (T) ReflectionUtils.getField(field, boundObject);
    }
}
