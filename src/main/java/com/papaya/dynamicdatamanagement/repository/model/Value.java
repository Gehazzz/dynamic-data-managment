package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Value parentValue;
    @OneToMany(mappedBy = "parentValue",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Value> values = new ArrayList<>();
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "value_validation_rule",
            joinColumns = @JoinColumn(name = "value_id"),
            inverseJoinColumns = @JoinColumn(name = "validation_rule_id")
    )
    private Set<ValidationRule> validationRules = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckboxDetails checkboxDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckboxGroupDetails checkboxGroupDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private DropDownDetails dropDownDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private InputFieldDetails inputFieldDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private RadioGroupDetails radioGroupDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private TextAreaDetails textAreaDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionSubmission sectionSubmission;
    private InputJavaType type;

    public void addValue(Value value){
        values.add(value);
        value.addValue(this);
    }

    public void removeValue(Value value){
        values.remove(value);
        value.removeValue(this);
    }

    public void addValidationRule(ValidationRule validationRule){
        validationRules.add(validationRule);
        validationRule.addValue(this);
    }

    public void removeValidationRule(ValidationRule validationRule){
        validationRules.remove(validationRule);
        validationRule.removeValue(this);
    }
}
