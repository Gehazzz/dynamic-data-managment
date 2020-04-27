package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Table(name = "country", schema = "papaya")
public class Country {
    @Id
    @Column(name = "id", nullable = false, length = 2)
    private String id;
    private String name;
}
