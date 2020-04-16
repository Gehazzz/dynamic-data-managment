package com.papaya.dynamicdatamanagement.adapter.element;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormCreationTemplatePort;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import com.papaya.dynamicdatamanagement.repository.FormTemplateRepository;
import com.papaya.dynamicdatamanagement.repository.model.template.AbstractFormElementTemplate;
import com.papaya.dynamicdatamanagement.repository.model.template.CheckboxTemplate;
import com.papaya.dynamicdatamanagement.form.elements.Checkbox;
import com.papaya.dynamicdatamanagement.form.elements.main.AbstractFormElement;
import com.papaya.dynamicdatamanagement.repository.model.template.FormTemplate;
import com.papaya.dynamicdatamanagement.repository.model.template.FormTemplateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckBoxAdapter implements QueryFormCreationTemplatePort
{

    @Autowired
    private FormTemplateRepository formTemplateRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public AbstractFormElement mapToServiceEntity(AbstractFormElementTemplate abstractFormElementTemplate) {
        CheckboxTemplate checkboxTemplate = objectMapper.convertValue(abstractFormElementTemplate, CheckboxTemplate.class);
        Checkbox.builder()
                .id(checkboxTemplate.getId())
                .discarded(checkboxTemplate.isDiscarded())
                .enabled(checkboxTemplate.isEnabled())
                .hint(checkboxTemplate.getHint())
                .label(checkboxTemplate.getLabel())
                .required(checkboxTemplate.isRequired());
        return null;
    }

    public AbstractFormElementTemplate mapToDataEntity(AbstractFormElement abstractFormElement) {
        return null;
    }

    FormTemplateType getFormTemplateType(FormType formType){
        if(FormType.DYNAMIC_CREATION_TEMPLATE.equals(formType)){
            return FormTemplateType.DYNAMIC_CREATION_TEMPLATE;
        }
        if(FormType.DYNAMIC.equals(formType)){
            return FormTemplateType.DYNAMIC;
        }
        if(FormType.WORKER_ON_BOARDING.equals(formType)){
            return FormTemplateType.WORKER_ON_BOARDING;
        }
        if(FormType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE.equals(formType)){
            return FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE;
        }
        if(FormType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formType)){
            return FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        return null;
    }

    FormType getFormType(FormTemplateType formTemplateType){
        if(FormTemplateType.DYNAMIC_CREATION_TEMPLATE.equals(formTemplateType)){
            return FormType.DYNAMIC_CREATION_TEMPLATE;
        }
        if(FormTemplateType.DYNAMIC.equals(formTemplateType)){
            return FormType.DYNAMIC;
        }
        if(FormTemplateType.WORKER_ON_BOARDING.equals(formTemplateType)){
            return FormType.WORKER_ON_BOARDING;
        }
        if(FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE.equals(formTemplateType)){
            return FormType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE;
        }
        if(FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formTemplateType)){
            return FormType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        return null;
    }

    @Override
    public Form getFormCreationTemplate(Long id) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .id(1L)
                .build())).get(0);
        Form.builder()
                .id(formTemplate.getId())
                .formType(getFormType(formTemplate.getFormType()));
        return null;
    }

    @Override
    public Form getFormCreationTemplate(String label, UsageLevel usageLevel) {
        return null;
    }

    @Override
    public List<Form> getAllFormCreationTemplates() {
        return null;
    }

    @Override
    public List<FormType> getAvailableFormCreationTemplateTypes(UsageLevel usageLevel) {
        return null;
    }
}
