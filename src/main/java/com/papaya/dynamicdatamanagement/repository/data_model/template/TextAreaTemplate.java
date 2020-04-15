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
public class TextAreaTemplate extends AbstractInputField {
    private String placeholder;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "text_area_value",
            joinColumns = @JoinColumn(name = "text_area_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}
