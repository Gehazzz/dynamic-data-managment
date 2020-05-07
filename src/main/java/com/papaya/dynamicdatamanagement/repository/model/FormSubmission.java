package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class FormSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private FormDetails formDetails;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private SectionSubmission mainSectionSubmission;
    @Enumerated(EnumType.STRING)
    FormSubmissionStatus status;
}
