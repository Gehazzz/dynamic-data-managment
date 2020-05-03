package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class SectionDetails extends AbstractFormElementTemplate {
    @Id
    private Long id;
    private String label;
   /* @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private FormDetails formDetails;*/
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

}
