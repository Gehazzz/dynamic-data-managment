package com.papaya.dynamicdatamanagement.data_model.template;

import com.papaya.dynamicdatamanagement.data_model.template.value.Value;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class InputField extends AbstractInputField{
    private String placeholder;
    private InputJavaType type;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "input_field_id")
    private List<ValidationRule> validationRules;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "input_field_value",
            joinColumns = @JoinColumn(name = "input_field_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}
