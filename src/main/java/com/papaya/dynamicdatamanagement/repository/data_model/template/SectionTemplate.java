package com.papaya.dynamicdatamanagement.repository.data_model.template;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SectionTemplate extends AbstractFormElementTemplate {
    private String label;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<SectionTemplate> sections;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<TextTemplate> textElements;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<InputField> inputFields;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<TextAreaTemplate> textAreas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<CheckboxTemplate> checkboxes;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<CheckboxGroupTemplate> checkboxGroups;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<RadioGroupTemplate> radioGroups;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<DropDownTemplate> dropDowns;

    @Builder
    public SectionTemplate(Long id, Integer index, SectionTemplate parentSection, boolean discarded, boolean visible, String label, List<SectionTemplate> sections, List<TextTemplate> textElements, List<InputField> inputFields, List<TextAreaTemplate> textAreas, List<CheckboxTemplate> checkboxes, List<CheckboxGroupTemplate> checkboxGroups, List<RadioGroupTemplate> radioGroups, List<DropDownTemplate> dropDowns) {
        super(id, index, parentSection, discarded, visible);
        this.label = label;
        this.sections = sections;
        this.textElements = textElements;
        this.inputFields = inputFields;
        this.textAreas = textAreas;
        this.checkboxes = checkboxes;
        this.checkboxGroups = checkboxGroups;
        this.radioGroups = radioGroups;
        this.dropDowns = dropDowns;
    }
}
