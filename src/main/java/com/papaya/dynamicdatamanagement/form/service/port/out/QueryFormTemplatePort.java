package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;

import java.util.List;

public interface QueryFormTemplatePort {
    Form getFormTemplate(Long id);
    Form getFormTemplate(String label, UsageLevel usageLevel);
    List<Form> getAllFormTemplates();
    List<FormType> getAvailableFormTemplateTypes(UsageLevel usageLevel);
}
