package com.papaya.dynamicdatamanagement.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CheckboxGroupDetails extends AbstractInputField {
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails parentSectionDetails;
    @OneToMany(mappedBy = "checkboxGroupDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Choice> choices = new ArrayList<>();

    @OneToMany(mappedBy = "checkboxGroupDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ValidationRule> validationRules = new ArrayList<>();

    /*    @OneToMany(cascade=CascadeType.ALL)
        @JoinTable(name = "checkbox_group_details_value",
                joinColumns = @JoinColumn(name = "checkbox_group_details_id"),
                inverseJoinColumns = @JoinColumn(name = "value_id")
        )
        List<Value> values;*/

    @OneToMany(mappedBy = "checkboxGroupDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Value> values = new ArrayList<>();

    public void addChoice(Choice choice){
        choices.add(choice);
        choice.setCheckboxGroupDetails(this);
    }

    public void removeChoice(Choice choice){
        choices.remove(choice);
        choice.setCheckboxGroupDetails(null);
    }

    public void addValidationRule(ValidationRule validationRule){
        validationRules.add(validationRule);
        validationRule.setCheckboxGroupDetails(this);
    }

    public void removeValidationRule(ValidationRule validationRule){
        validationRules.remove(validationRule);
        validationRule.setCheckboxGroupDetails(null);
    }

    public void addValue(Value value){
        values.add(value);
        value.setCheckboxGroupDetails(this);
    }

    public void removeValue(Value value){
        values.remove(value);
        value.setCheckboxGroupDetails(null);
    }
}
