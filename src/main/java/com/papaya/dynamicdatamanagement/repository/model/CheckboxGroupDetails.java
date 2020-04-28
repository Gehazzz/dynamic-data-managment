package com.papaya.dynamicdatamanagement.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CheckboxGroupDetails extends AbstractInputField {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_checkbox_group_details_id")
    List<Choice> choices;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "checkbox_group_details_id")
    private List<ValidationRule> validationRules;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "checkbox_group_details_value",
            joinColumns = @JoinColumn(name = "checkbox_group_details_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}