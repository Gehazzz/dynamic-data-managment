package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.elements.*;
import com.papaya.dynamicdatamanagement.form.elements.main.*;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormService;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FormManagerServiceImpl implements FormManagerService {

    Map<FormType, FormService> formServices;

    QueryFormPort queryFormPort;

    @Autowired
    public FormManagerServiceImpl(Set<FormService> formServices) {
        this.formServices = formServices.stream()
                .collect(Collectors.toMap(FormService::getType, Function.identity()));
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
    public List<Form> getForms(UsageLevel usageLevel) {
        return queryFormPort.getAllForms(usageLevel);
    }

    @Override
    public List<Form> getForms(FormType formType, UsageLevel usageLevel) {
        return queryFormPort.getAllForms(formType, usageLevel);
    }

    @Override
    public List<Form> getAllForms() {
        return queryFormPort.getAllForms();
    }

    @Override
    public Template getFormTemplateById(Long id) {
        Form form = queryFormPort.getForm(id);
        if (!form.getFormSubType().equals(FormSubType.TEMPLATE)) {
            throw new RuntimeException(String.format("Form template with id: %d doesn't exist", id));
        }
        return Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build();
    }

    @Override
    public Template getFormTemplateByFormId(Long id) {
        Form form = queryFormPort.getForm(id);
        if (!form.getFormSubType().equals(FormSubType.FORM)) {
            throw new RuntimeException(String.format("Form with id: %d doesn't exist", id));
        }
        return Template.builder()
                .form(form.getTemplate())
                .availableElements(getAvailableElements())
                .build();
    }

    @Override
    public Template getFormCreationTemplateById(Long id) {
        Form form = queryFormPort.getForm(id);
        if (!form.getFormSubType().equals(FormSubType.CREATION_TEMPLATE)) {
            throw new RuntimeException(String.format("Form creation template with id: %d doesn't exist", id));
        }
        return Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build();
    }

    @Override
    public Template getFormCreationTemplateByFormId(Long id) {
        Form form = queryFormPort.getForm(id);
        if (!form.getFormSubType().equals(FormSubType.FORM)) {
            throw new RuntimeException(String.format("Form with id: %d doesn't exist", id));
        }
        return Template.builder()
                .form(form.getTemplate().getTemplate())
                .availableElements(getAvailableElements())
                .build();
    }

    @Override
    public Template getFormCreationTemplateByFormTemplateId(Long id) {
        Form form = queryFormPort.getForm(id);
        if (!form.getFormSubType().equals(FormSubType.TEMPLATE)) {
            throw new RuntimeException(String.format("Form template with id: %d doesn't exist", id));
        }
        return Template.builder()
                .form(form.getTemplate())
                .availableElements(getAvailableElements())
                .build();
    }

    @Override
    public List<Template> getFormsTemplates(UsageLevel usageLevel) {
        return queryFormPort.getAllForms(FormSubType.TEMPLATE, usageLevel).stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Template> getFormsTemplates(FormType formType) {
        return queryFormPort.getAllForms(formType, FormSubType.TEMPLATE).stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Template> getFormsTemplates(FormType formType, UsageLevel usageLevel) {
        return queryFormPort.getAllForms(formType, FormSubType.TEMPLATE, usageLevel).stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Template> getAllFormsTemplates() {
        return queryFormPort.getAllForms(FormSubType.TEMPLATE).stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Template> getFormsCreationTemplates(UsageLevel usageLevel) {
        return queryFormPort.getAllForms(FormSubType.CREATION_TEMPLATE, usageLevel).stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Template> getFormsCreationTemplates(FormType formType) {
        return queryFormPort.getAllForms(formType, FormSubType.CREATION_TEMPLATE).stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Template> getFormsCreationTemplates(FormType formType, UsageLevel usageLevel) {
        return queryFormPort.getAllForms(formType, FormSubType.CREATION_TEMPLATE, usageLevel).stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public List<Template> getAllFormsCreationTemplates() {
        return queryFormPort.getAllForms(FormSubType.CREATION_TEMPLATE).stream().map(form -> Template.builder()
                .form(form)
                .availableElements(getAvailableElements())
                .build()).collect(Collectors.toList());
    }

    @Override
    public Form saveTemplate(Form template) {
        return formServices.get(template.getFormType()).saveTemplate(template);
    }

    @Override
    public Form saveFilledForm(FilledForm filledForm) {
        return formServices.get(filledForm.getFormType()).saveFilledForm(filledForm);
    }

    private List<AbstractFormElement> getAvailableElements() {
        return List.of(Section.builder().build(),
                Text.builder().build(),
                StringTextField.builder().build(),
                IntegerTextField.builder().build(),
                DoubleTextField.builder().build(),
                TextArea.builder().build(),
                DateTimeInput.builder().build(),
                Checkbox.builder().build(),
                CheckboxGroup.builder().build(),
                RadioGroup.builder().build(),
                DropDown.builder().build(),
                FileInput.builder().build()
        );
    }
}
