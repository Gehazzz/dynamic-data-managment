package com.papaya.dynamicdatamanagement.repository.model.template.value;

import com.papaya.dynamicdatamanagement.repository.model.template.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionValue {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private SectionTemplate section;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_value_id")
    private FormValue formValue;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<SectionValue> sectionValues;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_section_value_id")
    private List<Value> values;
}
