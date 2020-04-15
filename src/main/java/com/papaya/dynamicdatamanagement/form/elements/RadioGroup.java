package com.papaya.dynamicdatamanagement.form.elements;

public class RadioGroup<T> extends AbstractSingleChoice<T> {
    RadioGroup() {
    }

    public static <T> RadioGroupBuilder<T> builder() {
        return new RadioGroupBuilder<T>();
    }

    public static class RadioGroupBuilder<T> {
        RadioGroupBuilder() {
        }

        public RadioGroup<T> build() {
            return new RadioGroup<T>();
        }

        public String toString() {
            return "RadioGroup.RadioGroupBuilder()";
        }
    }
}
