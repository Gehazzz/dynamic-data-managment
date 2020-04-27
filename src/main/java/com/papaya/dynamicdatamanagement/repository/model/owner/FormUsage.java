package com.papaya.dynamicdatamanagement.repository.model.owner;

import com.papaya.dynamicdatamanagement.web.dto.RoleDTO;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;
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
    //TODO change to many to many
    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "form_usage_user",
            joinColumns = @JoinColumn(name = "form_usage_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
