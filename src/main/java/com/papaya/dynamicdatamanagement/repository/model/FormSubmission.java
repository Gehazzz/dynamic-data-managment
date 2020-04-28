package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//TODO FormValue rename to FormData or FilledForm
public class FormSubmission {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private FormDetails formDetails;
    @OneToOne(mappedBy = "formSubmission", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private SectionSubmission mainSectionSubmission;
    @Enumerated(EnumType.STRING)
    FormSubmissionStatus status;
}
