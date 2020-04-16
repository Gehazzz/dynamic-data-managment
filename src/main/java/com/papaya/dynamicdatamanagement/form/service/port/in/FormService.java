package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;

import java.util.EnumSet;
import java.util.List;

public interface FormService {
    /*List<FormType> getAllFormTypes();
    List<FormType> getAllFormTypesByUsageLevel(UsageLevel usageLevel);
    //Form getSupplementaryWorkerDefaultFormCreationTemplate();
    void saveForm();
    void updateForm();*/
    //Template getDefault();
    Template getFormCreationTemplate(FormType formType);
    EnumSet<FormType> getFormType();
}
