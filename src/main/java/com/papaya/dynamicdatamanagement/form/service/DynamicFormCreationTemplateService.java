package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService;
import org.springframework.stereotype.Service;

@Service
public class DynamicFormCreationTemplateService implements FormService {
    @Override
    public FormType getFormType() {
        return FormType.DYNAMIC_CREATION_TEMPLATE;
    }
}
