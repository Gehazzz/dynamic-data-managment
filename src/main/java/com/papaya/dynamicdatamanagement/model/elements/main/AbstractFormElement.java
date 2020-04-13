package com.papaya.dynamicdatamanagement.model.elements.main;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractFormElement {
    private String id;

    private Integer index;

    private Section parentSection;

    private boolean discarded = false;

    private boolean visible = true;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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
}
