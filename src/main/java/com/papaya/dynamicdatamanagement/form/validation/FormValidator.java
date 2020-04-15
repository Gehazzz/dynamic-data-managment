package com.papaya.dynamicdatamanagement.form.validation;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;

import java.util.Set;

public interface FormValidator {
    Set<String> validate(Form form);

}
