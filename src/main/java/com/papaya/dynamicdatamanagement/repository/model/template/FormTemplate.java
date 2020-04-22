package com.papaya.dynamicdatamanagement.repository.model.template;

import com.papaya.dynamicdatamanagement.repository.model.owner.FormUsage;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class FormTemplate {
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    @Enumerated(EnumType.STRING)
    private FormTemplateType formType;
    @Enumerated(EnumType.STRING)
    private FormTemplateSubType formTemplateSubType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    private FormTemplate template;
    @OneToMany(mappedBy = "template",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FormTemplate> createdByThisTemplate;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "form_id")
    private SectionTemplate mainSection;

    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "form_template_form_usage",
            joinColumns = @JoinColumn(name = "form_template_id"),
            inverseJoinColumns = @JoinColumn(name = "form_usage_id")
    )
    private List<FormUsage> formUsages;
}
