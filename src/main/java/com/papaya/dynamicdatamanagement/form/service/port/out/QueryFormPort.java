package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormSubType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;

import java.util.List;

public interface QueryFormPort {
    Form getForm(Long id);
    Form getForm(Long id, FormSubType subType);
    Form getForm(Long id, String label, FormSubType subType);
    List<Form> getAllForms();
    List<Form> getAllForms(FormSubType subType);
    List<Form> getAllForms(FormType formType, FormSubType subType);
    List<Form> getAllForms(FormSubType formSubType, UsageLevel usageLevel);
    List<Form> getAllForms(UsageLevel usageLevel);
    List<Form> getAllForms(FormType formType, UsageLevel usageLevel);
    List<Form> getAllForms(FormType formType, FormSubType subType, UsageLevel usageLevel);
    List<Form> getAllForms(FormType formType, FormSubType subType, UsageLevel usageLevel, String label);
}
