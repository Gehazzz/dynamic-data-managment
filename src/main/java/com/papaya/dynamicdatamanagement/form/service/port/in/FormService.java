package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

public interface FormService {
    List<FormType> getFormCreationTypes();

    List<FormType> getFormTemplatesTypes();

    //will return all forms available to current user
    List<Form> getAllForms();

    List<Form> getForms(FormQuery formQuery);

    Form getForm(long id);

    Form saveFilledForm(FilledForm filledForm);

    FormType getType();

    @Getter
    @Builder
    class FormQuery {
        private long id;
        private String label;
        private FormType formType;
        private long organizationId;
        private long countryId;
        private long projectId;
        private long userId;
    }

    @Getter
    @Builder
    class FilledForm {
        private long formId;
        private FormType formType;
        private Map<String, String> userInputs;
    }
}
