package com.papaya.dynamicdatamanagement.form.elements;

import com.papaya.dynamicdatamanagement.form.elements.main.AbstractFormElement;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.elements.main.Text;

public enum FormElementType {
    TEXT(Text.class),

    CHECKBOX(Checkbox.class),

    TEXT_FIELD(TextField.class),

    DROPDOWN(DropDown.class),

    RADIO(RadioGroup.class),

    CHECKBOX_GROUP(CheckboxGroup.class),

    TEXT_AREA(TextArea.class),

    SECTION(Section.class),

    TEXTFIELD_STRING(StringTextField.class),

    TEXTFIELD_INTEGER(IntegerTextField.class);

    public static <T extends AbstractFormElement> FormElementType ofObject(AbstractFormElement formElement) {
        for (FormElementType elementType : FormElementType.values()) {
            if (elementType.getElementClass().isInstance(formElement)) {
                return elementType;
            }
        }
        return null;
    }

    private final Class<? extends AbstractFormElement> elementClass;

    FormElementType(Class<? extends AbstractFormElement> elementClass) {
        this.elementClass = elementClass;
    }

    public Class<? extends AbstractFormElement> getElementClass() {
        return this.elementClass;
    }
}
