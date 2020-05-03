package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Table(name = "project", schema = "papaya")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "customerId")
    @LazyCollection(LazyCollectionOption.TRUE)
    private Organisation organisation;
}
