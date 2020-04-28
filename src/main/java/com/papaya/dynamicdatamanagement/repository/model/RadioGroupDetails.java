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
public class RadioGroupDetails extends AbstractInputField{
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_radio_group_details_id")
    private List<Choice> choices;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "radio_group_details_value",
            joinColumns = @JoinColumn(name = "radio_group_details_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}