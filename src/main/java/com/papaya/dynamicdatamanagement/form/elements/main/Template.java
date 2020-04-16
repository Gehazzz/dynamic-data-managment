package com.papaya.dynamicdatamanagement.form.elements.main;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class Template {
    Form form;
    FormType formType;
    List<AbstractFormElement> availableElements;
}
