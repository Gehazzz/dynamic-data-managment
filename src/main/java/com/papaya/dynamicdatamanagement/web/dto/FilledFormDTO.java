package com.papaya.dynamicdatamanagement.web.dto;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@Builder
public class FilledFormDTO {
    Long formId;

    Long formValueId;
    /**
     * form type
     */
    FormType formType;
    /**
     * Filled form values map
     * key - label, value - user input
     */
    Map<String, String> userInputs;

}
