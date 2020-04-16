package com.papaya.dynamicdatamanagement.form.elements.main;

import com.papaya.dynamicdatamanagement.form.binding.Binding;
import lombok.Builder;

/**
 * A form element that simply displays as text. It should be treated as read only
 */
public class Text extends AbstractBoundField<String> {
    Text() {
    }

    @Builder
    public Text(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, Binding<String> binding) {
        super(id, htmlId, index, parentSection, discarded, visible, binding);
    }
}
