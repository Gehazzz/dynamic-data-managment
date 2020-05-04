package com.papaya.dynamicdatamanagement.repository.model;

import com.papaya.dynamicdatamanagement.form.elements.DropDown;
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
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "choice_index")
    private int index;
    private String value;
    private InputJavaType type;
    @ManyToOne(fetch = FetchType.LAZY)
    private DropDownDetails dropDownDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private RadioGroupDetails radioGroupDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckboxGroupDetails checkboxGroupDetails;

}
