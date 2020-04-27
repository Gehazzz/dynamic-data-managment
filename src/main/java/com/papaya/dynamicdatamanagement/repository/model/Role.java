package com.papaya.dynamicdatamanagement.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Builder
@Table(name = "role", schema = "papaya")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String title;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "org_role",
            joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "orgId")
    )
    private List<Organisation> organisations;

}