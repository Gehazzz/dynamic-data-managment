package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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
public class ValidationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @Enumerated(EnumType.STRING)
    @Column(name = "rule_constraint")
    private Constraint constraint;
    private String pattern;
    private int min;
    private int max;
    private String data;
    private LocalDateTime minDateTime;
    private LocalDateTime maxDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private InputFieldDetails inputFieldDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckboxGroupDetails checkboxGroupDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckboxDetails checkboxDetails;
    @ManyToMany(mappedBy = "validationRules")
    Set<Value> values =new HashSet<>();

    public void addValue(Value value){
        values.add(value);
        value.addValidationRule(this);
    }

    public void removeValue(Value value){
        values.remove(value);
        value.removeValidationRule(this);
    }
}
