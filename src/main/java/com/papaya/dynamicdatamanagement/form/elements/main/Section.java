package com.papaya.dynamicdatamanagement.form.elements.main;

import com.papaya.dynamicdatamanagement.form.elements.AbstractInputField;
import com.papaya.dynamicdatamanagement.form.validation.SectionValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor
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

    public List<String> validateAndGetViolations() {
        return validators.stream().flatMap(validator -> validator.validate(this).stream())
                .collect(Collectors.toList());
    }

    @Builder
    public Section(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, String label, List<SectionValidator> validators, List<AbstractFormElement> formElements, boolean hidden, boolean showRemoveButton1) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton);
        this.label = label;
        this.validators = validators;
        this.formElements = formElements;
        this.hidden = hidden;
        this.showRemoveButton = showRemoveButton1;
    }
}
