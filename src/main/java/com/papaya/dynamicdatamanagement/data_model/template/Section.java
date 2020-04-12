package com.papaya.dynamicdatamanagement.data_model.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Section extends AbstractFormElement {
    private String label;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<Section> sections;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<Text> textElements;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<InputField> inputFields;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<TextArea> textAreas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<Checkbox> checkboxes;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<CheckboxGroup> checkboxGroups;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<RadioGroup> radioGroups;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_id")
    private List<DropDown> dropDowns;
}
