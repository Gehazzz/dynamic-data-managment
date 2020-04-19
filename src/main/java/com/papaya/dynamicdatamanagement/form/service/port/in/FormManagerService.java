package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormSubType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public interface FormManagerService {
    EnumSet<FormType> getFormTypes();

    Form getForm(Long id);

    List<Form> getForms(UsageLevel usageLevel);

    List<Form> getForms(FormType formType, UsageLevel usageLevel);

    List<Form> getAllForms();

    Template getFormTemplateById(Long id);

    Template getFormTemplateByFormId(Long id);

    Template getFormCreationTemplateById(Long id);

    Template getFormCreationTemplateByFormId(Long id);

    Template getFormCreationTemplateByFormTemplateId(Long id);

    List<Template> getFormsTemplates(UsageLevel usageLevel);

    List<Template> getFormsTemplates(FormType formType);

    List<Template> getFormsTemplates(FormType formType, UsageLevel usageLevel);

    List<Template> getAllFormsTemplates();

    List<Template> getFormsCreationTemplates(UsageLevel usageLevel);

    List<Template> getFormsCreationTemplates(FormType formType);

    List<Template> getFormsCreationTemplates(FormType formType, UsageLevel usageLevel);

    List<Template> getAllFormsCreationTemplates();

    Form saveTemplate(Form template);

    Form saveFilledForm(FilledForm filledForm);

    @Getter
    @Builder
    class FormQuery {
        private String label;
        private FormType formType;
        private UsageLevel usageLevel;
    }

    class createFormCommand {
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
