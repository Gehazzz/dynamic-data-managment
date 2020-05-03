package com.papaya.dynamicdatamanagement.model_test;

import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import com.papaya.dynamicdatamanagement.form.elements.main.FormSubType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevel;
import com.papaya.dynamicdatamanagement.form.validation.FormValidator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
public class FormDTO{

    private Long id;

    private Form template;

    private SectionDTO mainSectionDTO;

    private ArrayList<FormValidator> validators;

    private String label;

    private FormType formType;

    private FormSubType formSubType;

    private List<UsageLevel> usageLevels;


    @Builder

    public FormDTO(Long id, Form template, SectionDTO mainSectionDTO, ArrayList<FormValidator> validators, String label, FormType formType, FormSubType formSubType, List<UsageLevel> usageLevels) {
        this.id = id;
        this.template = template;
        this.mainSectionDTO = mainSectionDTO;
        this.validators = validators;
        this.label = label;
        this.formType = formType;
        this.formSubType = formSubType;
        this.usageLevels = usageLevels;
    }
}
