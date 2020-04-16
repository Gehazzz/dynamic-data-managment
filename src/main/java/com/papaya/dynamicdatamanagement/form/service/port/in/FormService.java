package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;

import java.util.List;

public interface FormService {
    List<FormType> getAllAvailableFormCreationTypes();
    List<FormType> getAllAvailableFormTemplatesTypes();
    List<Form> getAllAvailableForms();
}
