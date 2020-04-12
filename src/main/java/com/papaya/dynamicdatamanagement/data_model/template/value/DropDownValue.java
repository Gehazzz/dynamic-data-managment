package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.Choice;
import com.papaya.dynamicdatamanagement.data_model.template.DropDown;
import com.papaya.dynamicdatamanagement.data_model.template.InputJavaType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DropDownValue {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private DropDown dropDown;
    @ManyToOne(fetch = FetchType.LAZY)
    private Choice choiceValue;
    private InputJavaType type;
}
