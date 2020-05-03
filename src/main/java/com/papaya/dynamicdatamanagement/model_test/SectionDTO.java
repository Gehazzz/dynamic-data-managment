package com.papaya.dynamicdatamanagement.model_test;

import com.papaya.dynamicdatamanagement.form.elements.*;
import com.papaya.dynamicdatamanagement.form.elements.main.AbstractFormElement;
import com.papaya.dynamicdatamanagement.form.elements.main.Section;
import com.papaya.dynamicdatamanagement.form.elements.main.Text;
import com.papaya.dynamicdatamanagement.form.validation.SectionValidator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
public class SectionDTO extends AbstractFormElement  {
    private String label;
    private List<SectionValidator> validators;
    List<TextField<?>> inputs;
    List<TextArea> textAreas;
    List<Text> texts;
    List<DropDown<?>> dropDowns;
    List<RadioGroup<?>> radioGroups;
    List<CheckboxGroup<?>> checkboxGroups;
    List<Checkbox> checkboxes;
    List<SectionDTO> sections;
    private boolean hidden = false;
    private boolean showRemoveButton = false;





    @Builder
    public SectionDTO(Long id, String htmlId, Integer index, Section parentSection, boolean discarded, boolean visible, boolean showRemoveButton, String label, List<SectionValidator> validators, List<TextField<?>> inputs, List<TextArea> textAreas, List<Text> texts, List<DropDown<?>> dropDowns, List<RadioGroup<?>> radioGroups, List<CheckboxGroup<?>> checkboxGroups, List<Checkbox> checkboxes, List<SectionDTO> sections, boolean hidden, boolean showRemoveButton1) {
        super(id, htmlId, index, parentSection, discarded, visible, showRemoveButton);
        this.label = label;
        this.validators = validators;
        this.inputs = inputs;
        this.textAreas = textAreas;
        this.texts = texts;
        this.dropDowns = dropDowns;
        this.radioGroups = radioGroups;
        this.checkboxGroups = checkboxGroups;
        this.checkboxes = checkboxes;
        this.sections = sections;
        this.hidden = hidden;
        this.showRemoveButton = showRemoveButton1;
    }
}
