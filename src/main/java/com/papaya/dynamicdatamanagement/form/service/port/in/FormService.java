package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;

public interface FormService {
    /*List<FormType> getAllFormTypes();
    List<FormType> getAllFormTypesByUsageLevel(UsageLevel usageLevel);
    //Form getSupplementaryWorkerDefaultFormCreationTemplate();
    void saveForm();
    void updateForm();*/
    //Template getDefault();
    Template getFormCreationTemplate(FormType formType);
    FormType.Service getType();
}
