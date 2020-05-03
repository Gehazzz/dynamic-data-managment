package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class InputFieldDetails extends AbstractInputField{
    private String placeholder;
    private InputJavaType type;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "input_field_details_id")
    private List<ValidationRule> validationRules;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "input_field_details_value",
            joinColumns = @JoinColumn(name = "input_field_details_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    List<Value> values;
}
