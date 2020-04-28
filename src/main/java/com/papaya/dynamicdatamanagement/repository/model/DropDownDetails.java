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
public class DropDownDetails extends AbstractInputField{
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_drop_down_details_id")
    List<Choice> choices;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "drop_down_details_value",
            joinColumns = @JoinColumn(name = "drop_down_details_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}
