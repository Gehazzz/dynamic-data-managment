package com.papaya.dynamicdatamanagement.form.elements.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public abstract class AbstractFormElement {

    private Long id;

    private String htmlId;

    private Integer index;
    @JsonIgnoreProperties({"formElements","inputFields"})
    private Section parentSection;

    private boolean discarded = false;

    private boolean visible = true;

    private boolean showRemoveButton = false;

    public void setHtmlId(String htmlId) {
        this.htmlId = htmlId;
    }

    public String getHtmlId() {
        return htmlId;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setParentSection(Section parentSection) {
        this.parentSection = parentSection;
    }

    public Section getParentSection() {
        return parentSection;
    }

    public void discard() {
        this.discarded = true;
        onDiscard();
    }

    public boolean isDiscarded() {
        return discarded;
    }

    public void onDiscard() {
        // do nothing by default
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public AbstractFormElement(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton) {
        this.id = id;
        this.htmlId = htmlId;
        this.index = index;
        this.parentSection = parentSection;
        this.discarded = discarded;
        this.visible = visible;
        this.showRemoveButton = showRemoveButton;
    }
}
