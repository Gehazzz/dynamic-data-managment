package com.papaya.dynamicdatamanagement.repository.model;

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
public class SectionDetails extends AbstractFormElementTemplate {
    private String label;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_details_id")
    private List<SectionDetails> sections;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_details_id")
    private List<TextDetails> textElements;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_details_id")
    private List<InputFieldDetails> inputFieldDetails;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_details_id")
    private List<TextAreaDetails> textAreas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_details_id")
    private List<CheckboxDetails> checkboxes;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_details_id")
    private List<CheckboxGroupDetails> checkboxGroups;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_details_id")
    private List<RadioGroupDetails> radioGroups;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_details_id")
    private List<DropDownDetails> dropDowns;

    @Builder
    public SectionDetails(Long id, Integer index, SectionDetails parentSection, boolean discarded, boolean visible, String label, List<SectionDetails> sections, List<TextDetails> textElements, List<InputFieldDetails> inputFieldDetails, List<TextAreaDetails> textAreas, List<CheckboxDetails> checkboxes, List<CheckboxGroupDetails> checkboxGroups, List<RadioGroupDetails> radioGroups, List<DropDownDetails> dropDowns) {
        super(id, index, parentSection, discarded, visible);
        this.label = label;
        this.sections = sections;
        this.textElements = textElements;
        this.inputFieldDetails = inputFieldDetails;
        this.textAreas = textAreas;
        this.checkboxes = checkboxes;
        this.checkboxGroups = checkboxGroups;
        this.radioGroups = radioGroups;
        this.dropDowns = dropDowns;
    }
}
