package com.papaya.dynamicdatamanagement.data_model.template;

import com.papaya.dynamicdatamanagement.data_model.template.value.Value;
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
public class CheckboxGroup extends AbstractInputField {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_checkbox_group_id")
    List<Choice> choices;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "checkbox_group_id")
    private List<ValidationRule> validationRules;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "checkbox_group_value",
            joinColumns = @JoinColumn(name = "checkbox_group_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}
