package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionValue {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Section section;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_value_id")
    private FormValue formValue;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<SectionValue> sectionValues;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<InputFieldValue> inputFieldsValues;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<TextAreaValue> textAreasValues;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<CheckboxValue> checkboxesValues;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<CheckboxGroupValue> checkboxGroupsValues;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<RadioGroupValue> radioGroupsValues;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<DropDownValue> dropDownsValues;
}
