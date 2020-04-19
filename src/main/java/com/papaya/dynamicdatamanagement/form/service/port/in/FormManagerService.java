package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

public interface FormManagerService {
    List<FormType> getFormCreationTypes();

    List<FormType> getFormTemplatesTypes();

    Form getForm(Long id);

    List<Form> getForms(FormQuery formQuery);

    //will return all forms available to current user
    List<Form> getAllForms();

    Template getFormTemplate(Long id);

    Template getFormCreationTemplate(Long id);

    List<Template> getFormTemplates(FormQuery formQuery);

    List<Template> getAllFormCreationTemplates();

    List<Template> getFormCreationTemplates(FormType formType);

    List<Template> getFormCreationTemplates(FormQuery formQuery);

    Form saveTemplate(Form template);

    Form saveFilledForm(FilledForm filledForm);

    @Getter
    @Builder
    class FormQuery {
        private String label;
        private FormType formType;
        private UsageLevel usageLevel;
    }

    class createFormCommand{
        private FormType formType;
        private Form form;
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
