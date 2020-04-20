package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.AbstractFormElement;
import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;

import java.util.List;
import java.util.Map;

import static com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService.FilledForm;
import static com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService.FormQuery;

public interface FormService2 {
    Form getDefaultTemplate();
    Form saveTemplate(Form form);
    Form saveFilledForm(Form form, Map<String, String> userInputs);
    List<AbstractFormElement> getAvailableElements(Form form);
    FormType getType();
}
