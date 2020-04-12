package com.papaya.dynamicdatamanagement.data_model.template;

import com.papaya.dynamicdatamanagement.data_model.template.value.CheckboxGroupValue;
import com.papaya.dynamicdatamanagement.data_model.template.value.DropDownValue;
import com.papaya.dynamicdatamanagement.data_model.template.value.RadioGroupValue;
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
public class Choice {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "choice_index")
    private int index;
    private String value;
    private InputJavaType type;
    @ManyToMany(mappedBy = "choiceValues")
    private List<CheckboxGroupValue> checkboxGroupValues;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "choice_id")
    List<DropDownValue> dropDownValues;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "choice_id")
    List<RadioGroupValue> radioGroupValues;
}
