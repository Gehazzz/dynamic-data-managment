package com.papaya.dynamicdatamanagement.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.papaya.dynamicdatamanagement.adapter.element.CheckBoxAdapter;
import com.papaya.dynamicdatamanagement.form.elements.Checkbox;
import com.papaya.dynamicdatamanagement.form.elements.main.AbstractFormElement;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.repository.model.CheckboxDetails;
import com.papaya.dynamicdatamanagement.repository.model.SectionDetails;
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

    Section getSectionFromTemplate(SectionDetails sectionDetails){
        List<AbstractFormElement> outputElements = new ArrayList<>();
        List<CheckboxDetails> checkboxDetails = sectionDetails.getCheckboxes();
        List<Checkbox> checkboxes = new ArrayList<>();
        if(checkboxDetails !=null && !checkboxDetails.isEmpty()){
            for (CheckboxDetails checkbox : checkboxDetails) {
                checkboxes.add(checkBoxAdapter.mapToServiceEntity(checkbox));
            }
        outputElements.addAll(checkboxes);
        }
        return Section.builder()
                .id(sectionDetails.getId())
                .visible(sectionDetails.isVisible())
                .discarded(sectionDetails.isDiscarded())
                .index(sectionDetails.getIndex())
                .label(sectionDetails.getLabel())
                .formElements(outputElements)
                .build();
    }

    SectionDetails getSectionTemplateFromSection(Section section){
        List<CheckboxDetails> checkboxDetails = section.getFormElements()
                .filter(abstractFormElement -> abstractFormElement instanceof Checkbox)
                .map(abstractFormElement -> objectMapper.convertValue(abstractFormElement, Checkbox.class))
                .map(checkbox -> checkBoxAdapter.mapToDataEntity(checkbox))
                .collect(Collectors.toList());
        return SectionDetails.builder()
                .id(section.getId())
                .label(section.getTitle())
                .discarded(section.isDiscarded())
                .visible(section.isVisible())
                .checkboxes(checkboxDetails).build();
    }

}
