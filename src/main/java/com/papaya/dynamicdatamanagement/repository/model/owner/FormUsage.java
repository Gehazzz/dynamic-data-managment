package com.papaya.dynamicdatamanagement.repository.model.owner;

import com.papaya.dynamicdatamanagement.web.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;
@Data
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
    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "form_usage_user",
            joinColumns = @JoinColumn(name = "form_usage_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
