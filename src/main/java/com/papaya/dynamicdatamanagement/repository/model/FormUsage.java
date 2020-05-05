package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.HashSet;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryIso;
    private Long organisationId;
    private Long projectId;
    @ToString.Exclude
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "form_usage_user",
            joinColumns = @JoinColumn(name = "form_usage_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    public void addUser(User user){
        users.add(user);
        user.getFormUsages().add(this);
        //user.addFormUsage(this);
    }
    public void removeUser(User user){
        users.remove(user);
        user.getFormUsages().remove(this);
        //user.removeFormUsage(this);
    }
}
