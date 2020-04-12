package com.papaya.dynamicdatamanagement.data_model.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractFormElement {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "element_index")
    private Integer index;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_section_id")
    private Section parentSection;
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
