package com.papaya.dynamicdatamanagement.repository.data_model.template;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationRule {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    @Enumerated(EnumType.STRING)
    @Column(name = "rule_constraint")
    private Constraint constraint;
    private String pattern;
    private int min;
    private int max;
    private LocalDateTime minDateTime;
    private LocalDateTime maxDateTime;
}
