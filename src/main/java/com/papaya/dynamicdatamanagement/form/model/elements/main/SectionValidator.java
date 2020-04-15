package com.papaya.dynamicdatamanagement.form.model.elements.main;

import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public interface SectionValidator {
    Set<String> validate(Section section);
}
