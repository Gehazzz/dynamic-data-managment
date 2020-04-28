package com.papaya.dynamicdatamanagement.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractFormElementTemplate {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "element_index")
    private Integer index;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_section_id")
    @JsonIgnore
    private SectionDetails parentSection;
    /**
     * Marks this form element as "discarded", meaning that the user did
     * something with the consequence that the input from this form element must
     * not be evaluated at form submission.
     */
    private boolean discarded = false;
    /**
     * Is this section should be visible
     */
    private boolean visible = true;
}
