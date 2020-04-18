package com.papaya.dynamicdatamanagement.form.validation;

import com.papaya.dynamicdatamanagement.form.elements.AbstractInputField;
import lombok.*;

import java.util.Collections;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BooleanValidator implements FieldValidator<Boolean> {

    private Boolean data;
    private String message;


    @Override
    public Set<String> validate(AbstractInputField<Boolean> inputField) {
        if (inputField.getUserInput()!=null && inputField.getUserInput().equals(data)){
            return Set.of(message);
        }
        return Collections.emptySet();
    }
}
