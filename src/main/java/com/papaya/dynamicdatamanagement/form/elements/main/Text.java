package com.papaya.dynamicdatamanagement.form.elements.main;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.papaya.dynamicdatamanagement.form.binding.Binding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * A form element that simply displays as text. It should be treated as read only
 */
@Getter
@JsonIgnoreProperties({"parentSection", "value"})
public class Text extends AbstractBoundField<String> {
    private String text;
    Text() {
    }
    @Builder
    public Text(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, Binding<String> binding, String text) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton, binding);
        this.text = text;
    }
}
