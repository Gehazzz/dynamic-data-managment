package com.papaya.dynamicdatamanagement.model.elements.main;

import lombok.experimental.SuperBuilder;

/**
 * A form element that simply displays as text. It should be treated as read only
 */
@SuperBuilder
public class Text extends AbstractBoundField<String> {
}
