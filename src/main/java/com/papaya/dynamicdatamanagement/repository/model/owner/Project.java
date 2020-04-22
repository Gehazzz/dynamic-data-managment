package com.papaya.dynamicdatamanagement.repository.model.owner;

import com.papaya.dynamicdatamanagement.repository.model.template.FormTemplate;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "customerId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Organisation organisation;
}
