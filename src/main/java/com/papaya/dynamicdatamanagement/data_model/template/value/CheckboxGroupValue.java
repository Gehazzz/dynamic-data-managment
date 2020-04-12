package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.CheckboxGroup;
import com.papaya.dynamicdatamanagement.data_model.template.Choice;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckboxGroupValue {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckboxGroup checkboxGroup;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "checkbox_group_value_choice",
            joinColumns = @JoinColumn(name = "checkbox_group_value_id"),
            inverseJoinColumns = @JoinColumn(name = "choice_id")
    )
    private List<Choice> choiceValues;
}
