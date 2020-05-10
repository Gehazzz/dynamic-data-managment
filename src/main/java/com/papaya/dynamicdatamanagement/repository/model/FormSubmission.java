package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class FormSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private FormDetails formDetails;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    private SectionSubmission mainSectionSubmission;
    @Enumerated(EnumType.STRING)
    FormSubmissionStatus status;
}
