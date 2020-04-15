package com.papaya.dynamicdatamanagement.form.model.elements;

import java.time.LocalDateTime;


public class DateTimeInput extends AbstractInputField<LocalDateTime> {
    DateTimeInput() {
    }

    public static DateTimeInputBuilder builder() {
        return new DateTimeInputBuilder();
    }

    public static class DateTimeInputBuilder {
        DateTimeInputBuilder() {
        }

        public DateTimeInput build() {
            return new DateTimeInput();
        }

        public String toString() {
            return "DateTimeInput.DateTimeInputBuilder()";
        }
    }
}
