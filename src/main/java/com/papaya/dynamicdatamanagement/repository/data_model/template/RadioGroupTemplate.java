package com.papaya.dynamicdatamanagement.repository.data_model.template;

import com.papaya.dynamicdatamanagement.repository.data_model.template.value.Value;
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
public class RadioGroupTemplate extends AbstractInputField{
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_radio_group_id")
    private List<Choice> choices;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "radio_group_value",
            joinColumns = @JoinColumn(name = "radio_group_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}
