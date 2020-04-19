package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;

import java.util.List;

import static com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService.*;

public interface FormService {
    /*List<FormType> getAllFormTypes();
    List<FormType> getAllFormTypesByUsageLevel(UsageLevel usageLevel);
    //Form getSupplementaryWorkerDefaultFormCreationTemplate();
    void saveForm();
    void updateForm();*/
    //Template getDefault();
    List<Template> getFormTemplates(FormQuery formQuery);
    List<Template> getFormCreationTemplates(FormQuery formQuery);
    Form saveTemplate(Form template);
    Form saveFilledForm(FilledForm filledForm);
    FormType getType();
}
