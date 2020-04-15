package com.papaya.dynamicdatamanagement.repository.data_model.owner;

import com.papaya.dynamicdatamanagement.repository.data_model.template.FormTemplate;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "countries")
    private List<FormTemplate> formTemplates;
}
