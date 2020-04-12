package com.papaya.dynamicdatamanagement.data_model.template;

import com.papaya.dynamicdatamanagement.data_model.template.value.InputFieldValue;
import lombok.*;
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
public class InputField extends AbstractInputField{
    private String placeholder;
    private InputJavaType type;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "input_field_id")
    private List<ValidationRule> validationRules;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "input_field_id")
    private List<InputFieldValue> inputFieldValues;
}
