package com.papaya.dynamicdatamanagement.form.model.elements.main;

import com.papaya.dynamicdatamanagement.form.model.elements.AbstractInputField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor
@AllArgsConstructor
public class Section extends AbstractFormElement {
    private String label;
    @Getter
    private List<SectionValidator> validators;

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

    public Stream<AbstractFormElement> getFormElements() {
        return this.formElements.stream();
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

    public static class SectionBuilder {
        private String label;
        private List<SectionValidator> sectionValidators;
        private List<AbstractFormElement> formElements;
        private boolean hidden;
        private boolean showRemoveButton;

        SectionBuilder() {
        }

        public SectionBuilder label(String label) {
            this.label = label;
            return this;
        }

        public SectionBuilder formElements(List<AbstractFormElement> formElements) {
            this.formElements = formElements;
            return this;
        }

        public SectionBuilder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public SectionBuilder showRemoveButton(boolean showRemoveButton) {
            this.showRemoveButton = showRemoveButton;
            return this;
        }

        public Section build() {
            return new Section(label, sectionValidators, formElements, hidden, showRemoveButton);
        }

        public String toString() {
            return "Section.SectionBuilder(label=" + this.label + ", formElements=" + this.formElements + ", hidden=" + this.hidden + ", showRemoveButton=" + this.showRemoveButton + ")";
        }
    }

    public List<AbstractInputField<?>> getInputFields() {
        return getFormElements().filter(e -> e instanceof AbstractInputField)
                .map(e -> ((AbstractInputField<?>) e))
                .collect(toList());

    }

    public List<Section> getEmbeddedSections() {
        return getFormElements().filter(e -> e instanceof Section)
                .map(e -> ((Section) e))
                .collect(toList());

    }
}
