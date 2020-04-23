package com.papaya.dynamicdatamanagement.web.dto;

public class FormPreviewDTO {
    Long formId;
    Long submissionId;//filled form
    FilledFormStatusDTO submissionStatus;
    String formLabel;
    boolean isBind;
}
