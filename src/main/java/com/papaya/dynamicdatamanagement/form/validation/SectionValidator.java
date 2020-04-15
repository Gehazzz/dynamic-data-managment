package com.papaya.dynamicdatamanagement.form.validation;

import com.papaya.dynamicdatamanagement.form.elements.main.Section;

import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public interface SectionValidator {
    Set<String> validate(Section section);
}
