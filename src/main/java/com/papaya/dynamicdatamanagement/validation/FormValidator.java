package com.papaya.dynamicdatamanagement.validation;

import com.papaya.dynamicdatamanagement.model.elements.main.Form;

import javax.validation.ConstraintViolation;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public interface FormValidator {
    Set<String> validate(Form form);

}
