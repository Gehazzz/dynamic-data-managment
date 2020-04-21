package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.*;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public interface FormManagerService2 {
    EnumSet<FormType> getFormTypes();

    Form getForm(Long id);

    Form getForm(Long id, FormType formType, FormSubType formSubType);

    List<Form> getForms(FormSubType formSubType);

    List<Form> getForms(FormSubType formSubType, UsageLevel usageLevel);

    List<Form> getForms(FormSubType formSubType, List<UsageLevel> usageLevels);

    List<Form> getForms(FormType formType, FormSubType formSubType);

    List<Form> getForms(FormType formType, FormSubType formSubType, UsageLevel usageLevel);

    List<Form> getForms(FormType formType, FormSubType formSubType, List<UsageLevel> usageLevels);

    List<Form> getAllForms();

    List<AbstractFormElement> getAvailableElements(Form form);

    Form saveTemplate(Form form);

    Form saveFilledForm(Form form, Map<String, String> userInputs);

    Form assignUsageLevel(Form form, UsageLevel usageLevel);
}
