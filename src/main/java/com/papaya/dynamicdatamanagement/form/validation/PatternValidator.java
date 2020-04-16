package com.papaya.dynamicdatamanagement.form.validation;

import com.papaya.dynamicdatamanagement.form.elements.AbstractInputField;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Getter
@Setter
@Builder
public class PatternValidator implements FieldValidator<String> {
    private Pattern pattern;
    private String message;
    @Override
    public Set<String> validate(AbstractInputField<String> inputField) {
        String userInput = inputField.getUserInput();
        Matcher matcher = pattern.matcher(userInput);
        if (!matcher.matches()) {
            return Set.of(message);
        }
        return Collections.emptySet();
    }
}
