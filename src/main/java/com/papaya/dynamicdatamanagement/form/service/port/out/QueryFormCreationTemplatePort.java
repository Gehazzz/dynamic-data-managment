package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;

import java.util.List;

import static com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService.*;

public interface QueryFormCreationTemplatePort {
    Form getFormCreationTemplate(Long id);
    Form getFormCreationTemplate(String label, UsageLevel usageLevel);
    List<Form> getAllFormCreationTemplates();
    List<Template> getAvailableFormCreationTemplateTypes(FormQuery formQuery);
}
