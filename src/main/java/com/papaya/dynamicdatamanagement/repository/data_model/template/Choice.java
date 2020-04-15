package com.papaya.dynamicdatamanagement.repository.data_model.template;

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
    @GeneratedValue
    private Long id;
    @Column(name = "choice_index")
    private int index;
    private String value;
    private InputJavaType type;

}
