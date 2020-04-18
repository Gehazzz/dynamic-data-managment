package com.papaya.dynamicdatamanagement.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.adapter.element.CheckBoxAdapter;
import com.papaya.dynamicdatamanagement.form.elements.Checkbox;
import com.papaya.dynamicdatamanagement.form.elements.main.AbstractFormElement;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.repository.model.template.AbstractFormElementTemplate;
import com.papaya.dynamicdatamanagement.repository.model.template.CheckboxTemplate;
import com.papaya.dynamicdatamanagement.repository.model.template.SectionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SectionMapper {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CheckBoxAdapter checkBoxAdapter;

    Section getSectionFromTemplate(SectionTemplate sectionTemplate){
        List<AbstractFormElement> outputElements = new ArrayList<>();
        List<CheckboxTemplate> checkboxTemplates = sectionTemplate.getCheckboxes();
        List<Checkbox> checkboxes = new ArrayList<>();
        if(checkboxTemplates!=null && !checkboxTemplates.isEmpty()){
            for (CheckboxTemplate checkboxTemplate : checkboxTemplates) {
                checkboxes.add(checkBoxAdapter.mapToServiceEntity(checkboxTemplate));
            }
        outputElements.addAll(checkboxes);
        }
        return Section.builder()
                .id(sectionTemplate.getId())
                .visible(sectionTemplate.isVisible())
                .discarded(sectionTemplate.isDiscarded())
                .index(sectionTemplate.getIndex())
                .label(sectionTemplate.getLabel())
                .formElements(outputElements)
                .build();
    }

    SectionTemplate getSectionTemplateFromSection(Section section){
        List<CheckboxTemplate> checkboxTemplates = section.getFormElements()
                .filter(abstractFormElement -> abstractFormElement instanceof Checkbox)
                .map(abstractFormElement -> objectMapper.convertValue(abstractFormElement, Checkbox.class))
                .map(checkbox -> checkBoxAdapter.mapToDataEntity(checkbox))
                .collect(Collectors.toList());
        return SectionTemplate.builder()
                .id(section.getId())
                .label(section.getTitle())
                .discarded(section.isDiscarded())
                .visible(section.isVisible())
                .checkboxes(checkboxTemplates).build();
    }

}
