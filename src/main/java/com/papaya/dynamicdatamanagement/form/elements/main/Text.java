package com.papaya.dynamicdatamanagement.form.elements.main;

/**
 * A form element that simply displays as text. It should be treated as read only
 */
public class Text extends AbstractBoundField<String> {
    Text() {
    }

    public static TextBuilder builder() {
        return new TextBuilder();
    }

    public static class TextBuilder {
        TextBuilder() {
        }

        public Text build() {
            return new Text();
        }

        public String toString() {
            return "Text.TextBuilder()";
        }
    }
}
