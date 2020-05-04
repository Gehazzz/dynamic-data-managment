package com.papaya.dynamicdatamanagement.repository.model;

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
//@AllArgsConstructor
public class CheckboxDetails extends AbstractInputField{

    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails parentSectionDetails;
    @OneToMany(mappedBy = "checkboxDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ValidationRule> validationRules = new ArrayList<>();


/*    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "checkbox_details_value",
            joinColumns = @JoinColumn(name = "checkbox_details_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;*/

    @OneToMany(mappedBy = "checkboxDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Value> values = new ArrayList<>();

    public void addValidationRule(ValidationRule validationRule) {
        validationRules.add(validationRule);
        validationRule.setCheckboxDetails(this);
    }

    public void removeValidationRule(ValidationRule validationRule) {
        validationRules.remove(validationRule);
        validationRule.setCheckboxDetails(null);
    }

    public void addValue(Value value) {
        values.add(value);
        value.setCheckboxDetails(this);
    }

    public void removeValue(Value value) {
        values.remove(value);
        value.setCheckboxDetails(null);
    }
}
