package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class FormUsage {
    @Id
    @GeneratedValue
    private Long id;
    private String countryIso;
    private Long organisationId;
    private Long projectId;
    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "form_usage_user",
            joinColumns = @JoinColumn(name = "form_usage_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;
}
