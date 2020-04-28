package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionSubmission {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails section;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_submission_id")
    private FormSubmission formSubmission;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_submission_id")
    private List<SectionSubmission> sectionSubmissions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_submission_id")
    private List<Value> values;
}
