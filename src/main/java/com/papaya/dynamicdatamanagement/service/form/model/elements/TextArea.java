package com.papaya.dynamicdatamanagement.service.form.model.elements;

public class TextArea extends AbstractInputField<String> {
    private String placeholder;

    @java.beans.ConstructorProperties({"placeholder"})
    TextArea(String placeholder) {
        this.placeholder = placeholder;
    }

    public static TextAreaBuilder builder() {
        return new TextAreaBuilder();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public Class<?> getModelClass() {
        return String.class;
    }

    public static class TextAreaBuilder {
        private String placeholder;

        TextAreaBuilder() {
        }

        public TextAreaBuilder placeholder(String placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public TextArea build() {
            return new TextArea(placeholder);
        }

        public String toString() {
            return "TextArea.TextAreaBuilder(placeholder=" + this.placeholder + ")";
        }
    }
}
