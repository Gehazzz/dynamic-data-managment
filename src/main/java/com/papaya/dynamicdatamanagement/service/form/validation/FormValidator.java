package com.papaya.dynamicdatamanagement.service.form.validation;

import com.papaya.dynamicdatamanagement.service.form.model.elements.main.Form;

import java.util.Set;

public interface FormValidator {
    Set<String> validate(Form form);

}
