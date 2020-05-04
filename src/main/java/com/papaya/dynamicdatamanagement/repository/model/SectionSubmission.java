package com.papaya.dynamicdatamanagement.repository.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionSubmission {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails section;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_submission_id")
    private List<SectionSubmission> sectionSubmissions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_submission_id")
    private List<Value> values = new ArrayList<>();
}
