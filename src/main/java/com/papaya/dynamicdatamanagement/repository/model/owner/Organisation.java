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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "org", schema = "papaya")
public class Organisation {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countryId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Country country;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "org_role",
    joinColumns = @JoinColumn(name = "orgId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<Role> roles;
}
