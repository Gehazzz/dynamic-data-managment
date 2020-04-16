package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FormManagerServiceImpl implements FormManagerService {

    Map<FormType, FormService> formServices;

    @Autowired
    public FormManagerServiceImpl(Set<FormService> formServices) {
        this.formServices = formServices.stream()
                .collect(Collectors.toMap(FormService::getFormType, Function.identity()));
    }

    @Override
    public List<FormType> getFormCreationTypes() {
        return null;
    }

    @Override
    public List<FormType> getFormTemplatesTypes() {
        return null;
    }

    @Override
    public List<Form> getAllForms() {
        return null;
    }

    @Override
    public List<Form> getForms(FormQuery formQuery) {
        return null;
    }

    @Override
    public Form getForm(long id) {
        return null;
    }

    @Override
    public Form saveFilledForm(FilledForm filledForm) {
        return null;
    }

    @Override
    public FormType getType() {
        return null;
    }
}
