package com.papaya.dynamicdatamanagement.data_model.template;

import com.papaya.dynamicdatamanagement.data_model.owner.Organisation;
import com.papaya.dynamicdatamanagement.data_model.owner.Project;
import com.papaya.dynamicdatamanagement.data_model.owner.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormTemplate {
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    //private FormType formType;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "form_id")
    private SectionTemplate mainSection;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "form_template_organisation",
            joinColumns = @JoinColumn(name = "form_template_id"),
            inverseJoinColumns = @JoinColumn(name = "organisation_id")
    )
    private List<Organisation> organisations;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "form_template_project",
            joinColumns = @JoinColumn(name = "form_template_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "form_template_user",
            joinColumns = @JoinColumn(name = "form_template_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
