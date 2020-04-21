package com.papaya.dynamicdatamanagement.adapter;

import com.papaya.dynamicdatamanagement.adapter.element.UsageLevelAdapter;
import com.papaya.dynamicdatamanagement.form.elements.main.FormSubType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.form.usage.*;
import com.papaya.dynamicdatamanagement.repository.FormTemplateRepository;
import com.papaya.dynamicdatamanagement.repository.model.template.*;
import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryFormPortImpl implements QueryFormPort {

    @Autowired
    private UsageLevelAdapter usageLevelAdapter;


    @Autowired
    private FormTemplateRepository formTemplateRepository;

    @Autowired
    private SectionMapper sectionMapper;


    @Override
    public Form getForm(Long id) {
        return convertTemplateToForm(formTemplateRepository.findById(id).get());
    }

    @Override
    public Form getForm(Long id, FormSubType subType) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build())).get(0);
        return convertTemplateToForm(formTemplate);
    }

    @Override
    public Form getForm(Long id, FormType formType, FormSubType subType) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .formType(getFormTemplateType(formType))
                .id(id)
                .build())).get(0);
        return convertTemplateToForm(formTemplate);
    }

    @Override
    public Form getForm(Long id, String label, FormSubType subType) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .label(label)
                .build())).get(0);
        return convertTemplateToForm(formTemplate);
    }

    @Override
    public List<Form> getAllForms() {
        return formTemplateRepository.findAll().stream().map(this::convertTemplateToForm).collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormSubType subType) {
      return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build())).stream().map(this::convertTemplateToForm).collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormSubType formSubType, UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(usageLevelAdapter.getUsersFromUsageLevelUsers(usageLevel.getUsageLevelRoles()))
                .projects(usageLevelAdapter.getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(usageLevelAdapter.getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(usageLevelAdapter.getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(formSubType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(usageLevelAdapter.getUsersFromUsageLevelUsers(usageLevel.getUsageLevelRoles()))
                .projects(usageLevelAdapter.getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(usageLevelAdapter.getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(usageLevelAdapter.getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(usageLevelAdapter.getUsersFromUsageLevelUsers(usageLevel.getUsageLevelRoles()))
                .projects(usageLevelAdapter.getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(usageLevelAdapter.getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(usageLevelAdapter.getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .formType(getFormTemplateType(formType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType, UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(usageLevelAdapter.getUsersFromUsageLevelUsers(usageLevel.getUsageLevelRoles()))
                .projects(usageLevelAdapter.getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(usageLevelAdapter.getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(usageLevelAdapter.getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .formType(getFormTemplateType(formType))
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType, UsageLevel usageLevel, String label) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(usageLevelAdapter.getUsersFromUsageLevelUsers(usageLevel.getUsageLevelRoles()))
                .projects(usageLevelAdapter.getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(usageLevelAdapter.getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(usageLevelAdapter.getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .formType(getFormTemplateType(formType))
                .label(label)
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    private Form convertTemplateToForm(FormTemplate formTemplate){
        return Form.builder()
                .id(formTemplate.getId())
                .formType(getFormType(formTemplate.getFormType()))
                .usageLevel(usageLevelAdapter.calculateUsageLevelFromFormTemplate(formTemplate))
                .mainSection(sectionMapper.getSectionFromTemplate(formTemplate.getMainSection())).build();
    }


    public List<FormType> getAvailableFormCreationTemplateTypes(UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(usageLevelAdapter.getUsersFromUsageLevelUsers(usageLevel.getUsageLevelRoles()))
                .projects(usageLevelAdapter.getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .organisations(usageLevelAdapter.getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .countries(usageLevelAdapter.getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .build())).stream().map(formTemplate -> getFormType(formTemplate.getFormType())).collect(Collectors.toList());
    }

    FormTemplateType getFormTemplateType(FormType formType){
        if(FormType.DYNAMIC.equals(formType)){
            return FormTemplateType.DYNAMIC;
        }
        else if(FormType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formType)){
            return FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        else if(FormType.WORKER_ON_BOARDING.equals(formType)){
            return FormTemplateType.WORKER_ON_BOARDING;
        }
        else if(FormType.PAYMENT_TEMPLATE.equals(formType)){
            return FormTemplateType.PAYMENT_TEMPLATE;
        }
        return null;
    }



    FormType getFormType(FormTemplateType formTemplateType){
        if(FormTemplateType.DYNAMIC.equals(formTemplateType)){
            return FormType.DYNAMIC;
        }
        if(FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formTemplateType)){
            return FormType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        else if(FormTemplateType.WORKER_ON_BOARDING.equals(formTemplateType)){
            return FormType.WORKER_ON_BOARDING;
        }
        else if(FormTemplateType.PAYMENT_TEMPLATE.equals(formTemplateType)){
            return FormType.PAYMENT_TEMPLATE;
        }
        return null;
    }



    FormSubType getFormSubTypeFromFormTemplateSubType(FormTemplateSubType formTemplateSubType){
        if(FormTemplateSubType.CREATION_TEMPLATE.equals(formTemplateSubType)){
            return FormSubType.CREATION_TEMPLATE;
        }
        if(FormTemplateSubType.FORM.equals(formTemplateSubType)){
            return FormSubType.FORM;
        }
        if(FormTemplateSubType.TEMPLATE.equals(formTemplateSubType)){
            return FormSubType.TEMPLATE;
        }
        return null;
    }

    FormTemplateSubType getFormTemplateSubTypeFromFormSubType(FormSubType formSubType){
        if(FormSubType.CREATION_TEMPLATE.equals(formSubType)){
            return FormTemplateSubType.CREATION_TEMPLATE;
        }
        if(FormSubType.FORM.equals(formSubType)){
            return FormTemplateSubType.FORM;
        }
        if(FormSubType.TEMPLATE.equals(formSubType)){
            return FormTemplateSubType.TEMPLATE;
        }
        return null;
    }

}
