package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FormManagerServiceImpl /*implements FormManagerService*/ {

    Map<FormType, FormService> formServices;

    @Autowired
    public FormManagerServiceImpl(Set<FormService> formServices) {
        this.formServices = formServices.stream()
                .collect(Collectors.toMap(FormService::getType, Function.identity()));
    }

    //@Override
    public List<FormType> getFormCreationTypes() {
        return null;
    }

    //@Override
    public List<FormType> getFormTemplatesTypes() {
        return null;
    }

    //@Override
    public List<Form> getAllForms() {
        return null;
    }

    //@Override
    public List<Form> getForms(FormManagerService.FormQuery formQuery) {
        return null;
    }

  /*  @Override
    public Template getFormCreationTemplate(FormQuery formQuery) {
        *//*FormService formService = formServices.entrySet().stream()
                .filter(entry -> entry.getKey().getFormCreationTemplate().equals(formType))
                .map(Map.Entry::getValue).findFirst()
                .orElseThrow(() -> new RuntimeException("Provided formType doesn't exist"));
        return formService.getFormCreationTemplate(formType);*//*
        return formServices.get(formQuery.getFormType()).getFormCreationTemplate(formQuery);
    }

    @Override
    public Form getFormTemplate(FormType formType) {
        return null;
    }

    @Override
    public Form getForm(long id) {
        return null;
    }*/

    //@Override
    public Form saveFilledForm(FormManagerService.FilledForm filledForm) {
        return null;
    }
}
