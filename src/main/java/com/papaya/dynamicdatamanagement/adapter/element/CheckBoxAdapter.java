package com.papaya.dynamicdatamanagement.adapter.element;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.repository.model.template.AbstractFormElementTemplate;
import com.papaya.dynamicdatamanagement.repository.model.template.CheckboxTemplate;
import com.papaya.dynamicdatamanagement.form.model.elements.Checkbox;
import com.papaya.dynamicdatamanagement.form.model.elements.main.AbstractFormElement;

public class CheckBoxAdapter implements AbstractFormElementMapper
{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
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

    @Override
    public AbstractFormElementTemplate mapToDataEntity(AbstractFormElement abstractFormElement) {
        return null;
    }

}
