package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.main.AbstractFormElement;
import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormSubType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService2;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService2;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FormManagerService2Impl implements FormManagerService2 {

    private Map<FormType, FormService2> formServices;

    private QueryFormPort queryFormPort;

    @Autowired
    public FormManagerService2Impl(Set<FormService2> formServices,QueryFormPort queryFormPort) {
        this.formServices = formServices.stream()
                .collect(Collectors.toMap(FormService2::getType, Function.identity()));
        this.queryFormPort=queryFormPort;
    }

    @Override
    public EnumSet<FormType> getFormTypes() {
        return EnumSet.allOf(FormType.class);
    }

    @Override
    public Form getForm(Long id) {
        Form form = queryFormPort.getForm(id);
        if (!form.getFormSubType().equals(FormSubType.FORM)) {
            throw new RuntimeException(String.format("Form with id: %d doesn't exist", id));
        }
        return form;
    }

    @Override
    public Form getForm(Long id, FormType formType, FormSubType formSubType) {
        return queryFormPort.getForm(id, formType, formSubType);
    }

    @Override
    public List<Form> getForms(FormSubType formSubType) {
        return queryFormPort.getAllForms(formSubType);
    }

    @Override
    public List<Form> getForms(FormSubType formSubType, UsageLevel usageLevel) {
        return queryFormPort.getAllForms(formSubType, usageLevel);
    }

    @Override
    public List<Form> getForms(FormSubType formSubType, List<UsageLevel> usageLevels) {
        return queryFormPort.getAllForms(formSubType, usageLevels);
    }

    @Override
    public List<Form> getForms(FormType formType, FormSubType formSubType) {
        return queryFormPort.getAllForms(formType, formSubType);
    }

    @Override
    public List<Form> getForms(FormType formType, FormSubType formSubType, UsageLevel usageLevel) {
        return queryFormPort.getAllForms(formType, formSubType, usageLevel);
    }

    @Override
    public List<Form> getForms(FormType formType, FormSubType formSubType, List<UsageLevel> usageLevels) {
        return queryFormPort.getAllForms(formType, formSubType, usageLevels);
    }

    @Override
    public List<Form> getAllForms() {
        return queryFormPort.getAllForms();
    }

    @Override
    public List<AbstractFormElement> getAvailableElements(Form form) {
        return formServices.get(form.getFormType()).getAvailableElements(form);
    }

    @Override
    public Form saveTemplate(Form form) {
        return formServices.get(form.getFormType()).saveTemplate(form);
    }

    @Override
    public Form saveFilledForm(Form form, Map<String, String> userInputs) {
        return formServices.get(form.getFormType()).saveFilledForm(form, userInputs);
    }

    @Override
    public Form assignUsageLevel(Form form, UsageLevel usageLevel) {
        return null;
    }
}
