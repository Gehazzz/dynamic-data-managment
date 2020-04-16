package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;

import java.util.List;

public interface QueryFormPort {
    Form getForm(Long id);
    Form getForm(String label, UsageLevel usageLevel);
    List<Form> getAllForms();
    //List<FormType> getAllFormTypes();
    List<Form> getAllForms(UsageLevel usageLevel);
    List<FormType> getAvailableFormTypes(UsageLevel usageLevel);
}
