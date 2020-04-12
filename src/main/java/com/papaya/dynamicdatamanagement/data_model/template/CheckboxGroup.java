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
public class CheckboxGroup extends AbstractInputField {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_checkbox_group_id")
    List<Choice> choices;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "checkbox_group_id")
    private List<ValidationRule> validationRules;
}
