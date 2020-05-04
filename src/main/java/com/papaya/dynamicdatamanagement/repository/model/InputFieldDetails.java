package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class InputFieldDetails extends AbstractInputField {
    private String placeholder;
    private InputJavaType type;
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails parentSectionDetails;
    @OneToMany(mappedBy = "inputFieldDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ValidationRule> validationRules = new ArrayList<>();

    /*    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
        @Fetch(FetchMode.JOIN)
        @JoinTable(name = "input_field_details_value",
                joinColumns = @JoinColumn(name = "input_field_details_id"),
                inverseJoinColumns = @JoinColumn(name = "value_id")
        )
        List<Value> values;*/

    @OneToMany(mappedBy = "inputFieldDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Value> values = new ArrayList<>();

    public void addValidationRule(ValidationRule validationRule) {
        validationRules.add(validationRule);
        validationRule.setInputFieldDetails(this);
    }

    public void removeValidationRule(ValidationRule validationRule) {
        validationRules.remove(validationRule);
        validationRule.setInputFieldDetails(null);
    }

    public void addValue(Value value) {
        values.add(value);
        value.setInputFieldDetails(this);
    }

    public void removeValue(Value value) {
        values.remove(value);
        value.setInputFieldDetails(null);
    }
}
