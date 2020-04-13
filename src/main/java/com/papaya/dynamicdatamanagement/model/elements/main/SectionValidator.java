package com.papaya.dynamicdatamanagement.model.elements.main;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public interface SectionValidator {
    Set<ConstraintViolation<?>> validate(Section section);
}
