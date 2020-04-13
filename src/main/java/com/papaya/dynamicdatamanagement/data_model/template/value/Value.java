package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @Column(columnDefinition="LONGTEXT")
    private String value;
   /// private String longTextValue;
    private String boundTableName;
    private String boundClassName;
    private String boundColumnName;
    private String boundPropertyName;
    private Long boundTableRowId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_value_id")
    private List<Value> values;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "value_id")
    private List<ValidationRule> validationRules;
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
