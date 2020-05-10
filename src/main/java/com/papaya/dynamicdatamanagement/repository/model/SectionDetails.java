package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class SectionDetails extends AbstractFormElementTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails parentSectionDetails;
    @OneToMany(mappedBy = "parentSectionDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SectionDetails> sections = new ArrayList<>();
    @OneToMany(mappedBy = "section",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<SectionSubmission> sectionSubmissions = new ArrayList<>();
    @OneToMany(mappedBy = "parentSectionDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<TextDetails> textElements = new ArrayList<>();
    @OneToMany(mappedBy = "parentSectionDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<InputFieldDetails> inputFields = new ArrayList<>();
    @OneToMany(mappedBy = "parentSectionDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<TextAreaDetails> textAreas = new ArrayList<>();
    @OneToMany(mappedBy = "parentSectionDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CheckboxDetails> checkboxes = new ArrayList<>();
    @OneToMany(mappedBy = "parentSectionDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CheckboxGroupDetails> checkboxGroups = new ArrayList<>();
    @OneToMany(mappedBy = "parentSectionDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<RadioGroupDetails> radioGroups = new ArrayList<>();
    @OneToMany(mappedBy = "parentSectionDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<DropDownDetails> dropDowns = new ArrayList<>();

    public void addSectionSubmission(SectionSubmission sectionSubmission) {
        sectionSubmissions.add(sectionSubmission);
        sectionSubmission.setSection(this);
    }

    public void removeSectionSubmission(SectionSubmission sectionSubmission) {
        sectionSubmissions.remove(sectionSubmission);
        sectionSubmission.setSection(null);
    }

    public void addSectionDetails(SectionDetails sectionDetails) {
        sections.add(sectionDetails);
        sectionDetails.setParentSectionDetails(this);
    }

    public void removeSectionDetails(SectionDetails sectionDetails) {
        sections.remove(sectionDetails);
        sectionDetails.setParentSectionDetails(null);
    }

    public void addTextDetails(TextDetails textDetails) {
        textElements.add(textDetails);
        textDetails.setParentSectionDetails(this);
    }

    public void removeTextDetails(TextDetails textDetails) {
        textElements.remove(textDetails);
        textDetails.setParentSectionDetails(null);
    }

    public void addInputFieldDetails(InputFieldDetails inputFieldDetails) {
        inputFields.add(inputFieldDetails);
        inputFieldDetails.setParentSectionDetails(this);
    }

    public void removeInputFieldDetails(InputFieldDetails inputFieldDetails) {
        inputFields.remove(inputFieldDetails);
        inputFieldDetails.setParentSectionDetails(null);
    }

    public void addTextAreaDetails(TextAreaDetails textAreaDetails) {
        textAreas.add(textAreaDetails);
        textAreaDetails.setParentSectionDetails(this);
    }

    public void removeTextAreaDetails(TextAreaDetails textAreaDetails) {
        textAreas.remove(textAreaDetails);
        textAreaDetails.setParentSectionDetails(null);
    }

    public void addCheckboxDetails(CheckboxDetails checkboxDetails) {
        checkboxes.add(checkboxDetails);
        checkboxDetails.setParentSectionDetails(this);
    }

    public void removeCheckboxDetails(CheckboxDetails checkboxDetails) {
        checkboxes.remove(checkboxDetails);
        checkboxDetails.setParentSectionDetails(null);
    }

    public void addCheckboxGroupDetails(CheckboxGroupDetails checkboxGroupDetails) {
        checkboxGroups.add(checkboxGroupDetails);
        checkboxGroupDetails.setParentSectionDetails(this);
    }

    public void removeCheckboxGroupDetails(CheckboxGroupDetails checkboxGroupDetails) {
        checkboxGroups.remove(checkboxGroupDetails);
        checkboxGroupDetails.setParentSectionDetails(null);
    }

    public void addRadioGroupDetails(RadioGroupDetails radioGroupDetails) {
        radioGroups.add(radioGroupDetails);
        radioGroupDetails.setParentSectionDetails(this);
    }

    public void removeRadioGroupDetails(RadioGroupDetails radioGroupDetails) {
        radioGroups.remove(radioGroupDetails);
        radioGroupDetails.setParentSectionDetails(null);
    }

    public void addDropDownDetails(DropDownDetails dropDownDetails) {
        dropDowns.add(dropDownDetails);
        dropDownDetails.setParentSectionDetails(this);
    }

    public void removeDropDownDetails(DropDownDetails dropDownDetails) {
        dropDowns.remove(dropDownDetails);
        dropDownDetails.setParentSectionDetails(null);
    }
}
