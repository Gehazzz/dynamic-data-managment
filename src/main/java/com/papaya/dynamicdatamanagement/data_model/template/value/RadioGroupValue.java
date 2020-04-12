package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.Choice;
import com.papaya.dynamicdatamanagement.data_model.template.InputJavaType;
import com.papaya.dynamicdatamanagement.data_model.template.RadioGroup;
import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RadioGroupValue {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private RadioGroup radioGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    private Choice choiceValue;
    private InputJavaType type;
}
