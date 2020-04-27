package com.papaya.dynamicdatamanagement.repository.model;

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
    private String valueName;
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
    private CheckboxTemplate checkbox;
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckboxGroupTemplate checkboxGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    private DropDownTemplate dropDown;
    @ManyToOne(fetch = FetchType.LAZY)
    private InputField inputField;
    @ManyToOne(fetch = FetchType.LAZY)
    private RadioGroupTemplate radioGroup;
    @ManyToOne(fetch = FetchType.LAZY)
    private TextAreaTemplate textArea;
    private InputJavaType type;
}
