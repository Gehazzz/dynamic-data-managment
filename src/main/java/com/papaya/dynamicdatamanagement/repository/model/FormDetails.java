package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
//TODO FormTemplate rename to FormDetails
public class FormDetails {
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    @Enumerated(EnumType.STRING)
    private FormTypeDetails formType;
    @Enumerated(EnumType.STRING)
    private FormSubTypeDetails formSubTypeDetails;
    @Enumerated(EnumType.STRING)
    private FormStatusDetails status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_details_template_id")
    private FormDetails template;
    @OneToMany(mappedBy = "template",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FormDetails> createdByThisTemplate;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "form_details_id")
    private SectionDetails mainSection;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "form_details_form_usage",
            joinColumns = @JoinColumn(name = "form_details_id"),
            inverseJoinColumns = @JoinColumn(name = "form_usage_id")
    )
    private List<FormUsage> formUsages;
}
