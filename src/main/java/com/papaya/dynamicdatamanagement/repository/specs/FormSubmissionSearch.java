package com.papaya.dynamicdatamanagement.repository.specs;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.repository.model.FormSubmissionStatus;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
public class FormSubmissionSearch{
    String countryIso;
    Long organisationId;
    Long projectId;
    String userName;
    FormType formType;
    String label;
    FormSubmissionStatus status;
}
