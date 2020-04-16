package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;

import java.util.List;

public interface QueryFormCreationTemplatePort {
    Form getFormCreationTemplate(Long id);
    Form getFormCreationTemplate(String label, UsageLevel usageLevel);
    List<Form> getAllFormCreationTemplates();
    List<FormType> getAvailableFormCreationTemplateTypes(UsageLevel usageLevel);
}
