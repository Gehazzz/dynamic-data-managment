package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class FormDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private List<FormDetails> createdByThisTemplate = new ArrayList<>();

    /*@OneToOne(mappedBy = "formDetails", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
      private SectionDetails mainSection;*/
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private SectionDetails mainSection;

    @OneToMany(mappedBy = "formDetails",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FormSubmission> formSubmissions = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "form_details_form_usage",
            joinColumns = @JoinColumn(name = "form_details_id"),
            inverseJoinColumns = @JoinColumn(name = "form_usage_id")
    )
    private Set<FormUsage> formUsages = new HashSet<>();

    public void addFormDetails(FormDetails formDetails) {
        createdByThisTemplate.add(formDetails);
        formDetails.setTemplate(this);
    }

    public void removeFormDetails(FormDetails formDetails) {
        createdByThisTemplate.remove(formDetails);
        formDetails.setTemplate(null);
    }

    public void addFormSubmission(FormSubmission formSubmission){
        formSubmissions.add(formSubmission);
        formSubmission.setFormDetails(this);
    }

    public void removeFormSubmission(FormSubmission formSubmission){
        formSubmissions.remove(formSubmission);
        formSubmission.setFormDetails(null);
    }
}
