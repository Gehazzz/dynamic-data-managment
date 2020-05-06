package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"formUsages"})
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Table(name = "PAPAYA_USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String email;
    @ManyToMany(mappedBy = "users")
    Set<FormUsage> formUsages = new HashSet<>();

    public void addFormUsage(FormUsage formUsage){
        formUsages.add(formUsage);
        formUsage.getUsers().add(this);
    }
    public void removeFormUsage(FormUsage formUsage){
        formUsages.remove(formUsage);
        formUsage.getUsers().remove(this);
    }
}
