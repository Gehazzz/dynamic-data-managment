package com.papaya.dynamicdatamanagement.repository.model.owner;

import com.papaya.dynamicdatamanagement.repository.model.template.FormTemplate;
import lombok.*;
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
@Table(name = "country", schema = "papaya")
public class Country {
    @Id
    @Column(name = "id", nullable = false, length = 2)
    private String id;
    private String name;

    @ManyToMany(mappedBy = "countries")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FormTemplate> formTemplates;


}
