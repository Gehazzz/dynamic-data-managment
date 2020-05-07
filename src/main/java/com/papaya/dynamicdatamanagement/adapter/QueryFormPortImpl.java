package com.papaya.dynamicdatamanagement.adapter;

import com.papaya.dynamicdatamanagement.adapter.element.UsageLevelAdapter;
import com.papaya.dynamicdatamanagement.form.elements.main.FormSubType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.form.usage.*;
import com.papaya.dynamicdatamanagement.repository.FormDetailsRepository;
import com.papaya.dynamicdatamanagement.repository.model.FormDetails;
import com.papaya.dynamicdatamanagement.repository.model.FormSubTypeDetails;
import com.papaya.dynamicdatamanagement.repository.model.FormTypeDetails;
import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.repository.specs.FormSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class QueryFormPortImpl implements QueryFormPort {

    @Autowired
    private UsageLevelAdapter usageLevelAdapter;


    @Autowired
    private FormDetailsRepository formDetailsRepository;

    @Autowired
    private SectionMapper sectionMapper;


    @Override
    public Form getForm(Long id) {
        return convertTemplateToForm(formDetailsRepository.findById(id).get());
    }

    @Override
    public Form getForm(Long id, FormSubType subType) {
        FormDetails formDetails = formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formSubTypeDetails(getFormTemplateSubTypeFromFormSubType(subType))
                .build())).get(0);
        return convertTemplateToForm(formDetails);
    }

    @Override
    public Form getForm(Long id, FormType formType, FormSubType subType) {
        FormDetails formDetails = formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formSubTypeDetails(getFormTemplateSubTypeFromFormSubType(subType))
                .formType(getFormTemplateType(formType))
                .id(id)
                .build())).get(0);
        return convertTemplateToForm(formDetails);
    }

    @Override
    public Form getForm(Long id, String label, FormSubType subType) {
        FormDetails formDetails = formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formSubTypeDetails(getFormTemplateSubTypeFromFormSubType(subType))
                .label(label)
                .build())).get(0);
        return convertTemplateToForm(formDetails);
    }

    @Override
    public List<Form> getAllForms() {
        return formDetailsRepository.findAll().stream().map(this::convertTemplateToForm).collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormSubType subType) {
      return formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formSubTypeDetails(getFormTemplateSubTypeFromFormSubType(subType))
                .build())).stream().map(this::convertTemplateToForm).collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType) {
        return formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formSubTypeDetails(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormSubType formSubType, UsageLevel usageLevel) {
        return formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formUsages(usageLevelAdapter.getFormUsageSetFromUsageLevel(Set.of(usageLevel)))
                .formSubTypeDetails(getFormTemplateSubTypeFromFormSubType(formSubType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormSubType formSubType, List<UsageLevel> usageLevels) {
        return null;
    }

    @Override
    public List<Form> getAllForms(UsageLevel usageLevel) {
       return formDetailsRepository.findAll(FormSpecifications.searchFormDetails(usageLevel.getCountryIso(),usageLevel.getOrganisationId(),usageLevel.getProjectId(),usageLevel.getUsageLevelRoles().stream().map(usageLevelRole -> usageLevelAdapter.getRole(usageLevelRole)).collect(Collectors.toSet()))).stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, UsageLevel usageLevel) {
        return formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formUsages(usageLevelAdapter.getFormUsageSetFromUsageLevel(Set.of(usageLevel)))
                .formType(getFormTemplateType(formType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType, UsageLevel usageLevel) {
        return formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formUsages(usageLevelAdapter.getFormUsageSetFromUsageLevel(Set.of(usageLevel)))
                .formType(getFormTemplateType(formType))
                .formSubTypeDetails(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType formSubType, List<UsageLevel> usageLevels) {
        return null;
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType, UsageLevel usageLevel, String label) {
        return formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formUsages(usageLevelAdapter.getFormUsageSetFromUsageLevel(Set.of(usageLevel)))
                .formType(getFormTemplateType(formType))
                .label(label)
                .formSubTypeDetails(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType, List<UsageLevel> usageLevels, String label) {
        return null;
    }

    private Form convertTemplateToForm(FormDetails formDetails){
        return Form.builder()
                .id(formDetails.getId())
                .formType(getFormType(formDetails.getFormType()))
                .usageLevels(usageLevelAdapter.getUsageLevelsFromFormUsageSet(formDetails.getFormUsages()))
                .mainSection(sectionMapper.getSectionFromTemplate(formDetails.getMainSection())).build();
    }


    public List<FormType> getAvailableFormCreationTemplateTypes(UsageLevel usageLevel) {
        return formDetailsRepository.findAll(Example.of(FormDetails.builder()
                .formUsages(usageLevelAdapter.getFormUsageSetFromUsageLevel(Set.of(usageLevel)))
                .build())).stream().map(formTemplate -> getFormType(formTemplate.getFormType())).collect(Collectors.toList());
    }

    FormTypeDetails getFormTemplateType(FormType formType){
        if(FormType.DYNAMIC.equals(formType)){
            return FormTypeDetails.DYNAMIC;
        }
        else if(FormType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formType)){
            return FormTypeDetails.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        else if(FormType.WORKER_ON_BOARDING.equals(formType)){
            return FormTypeDetails.WORKER_ON_BOARDING;
        }
        else if(FormType.PAYMENT_TEMPLATE.equals(formType)){
            return FormTypeDetails.PAYMENT_TEMPLATE;
        }
        return null;
    }



    FormType getFormType(FormTypeDetails formTypeDetails){
        if(FormTypeDetails.DYNAMIC.equals(formTypeDetails)){
            return FormType.DYNAMIC;
        }
        if(FormTypeDetails.SUPPLEMENTARY_WORKER_INFORMATION.equals(formTypeDetails)){
            return FormType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        else if(FormTypeDetails.WORKER_ON_BOARDING.equals(formTypeDetails)){
            return FormType.WORKER_ON_BOARDING;
        }
        else if(FormTypeDetails.PAYMENT_TEMPLATE.equals(formTypeDetails)){
            return FormType.PAYMENT_TEMPLATE;
        }
        return null;
    }



    FormSubType getFormSubTypeFromFormTemplateSubType(FormSubTypeDetails formSubTypeDetails){
        if(FormSubTypeDetails.CREATION_TEMPLATE.equals(formSubTypeDetails)){
            return FormSubType.CREATION_TEMPLATE;
        }
        if(FormSubTypeDetails.FORM.equals(formSubTypeDetails)){
            return FormSubType.FORM;
        }
        if(FormSubTypeDetails.TEMPLATE.equals(formSubTypeDetails)){
            return FormSubType.TEMPLATE;
        }
        return null;
    }

    FormSubTypeDetails getFormTemplateSubTypeFromFormSubType(FormSubType formSubType){
        if(FormSubType.CREATION_TEMPLATE.equals(formSubType)){
            return FormSubTypeDetails.CREATION_TEMPLATE;
        }
        if(FormSubType.FORM.equals(formSubType)){
            return FormSubTypeDetails.FORM;
        }
        if(FormSubType.TEMPLATE.equals(formSubType)){
            return FormSubTypeDetails.TEMPLATE;
        }
        return null;
    }

}
