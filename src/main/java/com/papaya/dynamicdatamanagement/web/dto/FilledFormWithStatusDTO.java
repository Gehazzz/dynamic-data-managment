package com.papaya.dynamicdatamanagement.web.dto;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;

import java.util.Map;

public class FilledFormWithStatusDTO {
    Long formId;

    //Long formValueId;
    /**
     * form type
     */
    FormType formType;

    FilledFormStatusDTO status;
    /**
     * Filled form values map
     * key - label, value - user input
     */
    Map<String, String> userInputs;
}
