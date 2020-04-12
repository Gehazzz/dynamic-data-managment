package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.*;
import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Value {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
    private String longTextValue;
    @ManyToOne(fetch = FetchType.LAZY)
    private Checkbox checkbox;
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckboxGroup checkboxGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    private DropDown dropDown;
    @ManyToOne(fetch = FetchType.LAZY)
    private InputField inputField;
    @ManyToOne(fetch = FetchType.LAZY)
    private RadioGroup radioGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    private TextArea textArea;
    private InputJavaType type;
}
