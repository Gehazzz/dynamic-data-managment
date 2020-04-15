package com.papaya.dynamicdatamanagement.web;

import com.papaya.dynamicdatamanagement.service.form.model.elements.main.FormType;
import lombok.Builder;

import java.util.Map;

@Builder
public class FilledFormDTO {
    /**
     * form type
     */
    FormType formType;
    /**
     * Filled form values map
     * key - label, value - user input
     */
    Map<String, String> values;

}
