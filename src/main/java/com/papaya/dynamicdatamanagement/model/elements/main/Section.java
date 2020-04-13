package com.papaya.dynamicdatamanagement.model.elements.main;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Section extends AbstractFormElement {
    private String label;

    private List<AbstractFormElement> formElements = new ArrayList<AbstractFormElement>();

    private boolean hidden = false;
    //TODO place removale to AbstractFormElement
    private boolean showRemoveButton = false;

    public Section setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getTitle() {
        return this.label;
    }

    public Section add(AbstractFormElement element) {
        element.setIndex(this.formElements.size());
        element.setParentSection(this);
        this.formElements.add(element);
        return this;
    }

    public Section remove(AbstractFormElement elementToRemove) {
        if (this.formElements.remove(elementToRemove)) {
            elementToRemove.setParentSection(null);
            // shift the index of all form elements behind the new one by one
            for (AbstractFormElement element : this.formElements) {
                if (element.getIndex() > elementToRemove.getIndex()) {
                    element.setIndex(element.getIndex() - 1);
                }
            }
        }
        return this;
    }

    public Section insertBefore(AbstractFormElement newElement,
                                AbstractFormElement beforeThis) {
        int index = beforeThis.getIndex();
        if (index == -1) {
            throw new IllegalArgumentException(
                    "this section does not contain the form element before which to insert the new element!");
        }

        // shift the index of all form elements behind the new one by one
        for (AbstractFormElement element : this.formElements) {
            if (element.getIndex() >= index) {
                element.setIndex(element.getIndex() + 1);
            }
        }

        newElement.setParentSection(this);
        newElement.setIndex(index);
        this.formElements.add(newElement);
        return this;
    }

    public List<AbstractFormElement> getFormElements() {
        return Collections.unmodifiableList(this.formElements);
    }

    public Section setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Section setShowRemoveButton(boolean showRemoveButton) {
        this.showRemoveButton = showRemoveButton;
        return this;
    }

    public boolean isShowRemoveButton() {
        return this.showRemoveButton;
    }

    public AbstractFormElement getElementById(String id) {

        AbstractFormElement element = null;

        // this element is the searched one
        if (getId().equals(id)) {
            return this;
        } else {
            for (AbstractFormElement formElement : formElements) {

                // the child element is the searched one
                if (formElement.getId().equals(id)) {
                    return formElement;
                }

                // search in child-elements
                if (formElement instanceof Section) {
                    element = ((Section) formElement).getElementById(id);
                    if (element != null)
                        return element;
                }
            }
        }
        // no element found
        return null;
    }
}
