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
@ToString
public class SectionSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionDetails section;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionSubmission sectionSubmission;

    @OneToMany(mappedBy = "sectionSubmission", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<SectionSubmission> sectionSubmissions = new ArrayList<>();

    @OneToMany(mappedBy = "sectionSubmission", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Value> values = new ArrayList<>();

    public void addSectionSubmission(SectionSubmission sectionSubmission){
        sectionSubmissions.add(sectionSubmission);
        sectionSubmission.setSectionSubmission(this);
    }

    public void removeSectionSubmission(SectionSubmission sectionSubmission){
        sectionSubmissions.remove(sectionSubmission);
        sectionSubmission.setSectionSubmission(null);
    }

    public void addValue(Value value){
        values.add(value);
        value.setSectionSubmission(this);
    }

    public void removeValue(Value value){
        values.remove(value);
        value.setSectionSubmission(null);
    }
}
