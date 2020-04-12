package com.papaya.dynamicdatamanagement.data_model.template;

import com.papaya.dynamicdatamanagement.data_model.template.value.Value;
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
//@AllArgsConstructor
public class Checkbox extends AbstractInputField{

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "checkbox_value",
            joinColumns = @JoinColumn(name = "checkbox_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}
