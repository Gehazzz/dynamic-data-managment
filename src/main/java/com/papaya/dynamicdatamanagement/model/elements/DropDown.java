package com.papaya.dynamicdatamanagement.model.elements;

public class DropDown<T> extends AbstractSingleChoice<T> {
    DropDown() {
    }

    public static <T> DropDownBuilder<T> builder() {
        return new DropDownBuilder<T>();
    }

    public static class DropDownBuilder<T> {
        DropDownBuilder() {
        }

        public DropDown<T> build() {
            return new DropDown<T>();
        }

        public String toString() {
            return "DropDown.DropDownBuilder()";
        }
    }
}
