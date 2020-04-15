package com.papaya.dynamicdatamanagement.repository.model.template.value;

import com.papaya.dynamicdatamanagement.repository.model.template.FormTemplate;
import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormValue {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private FormTemplate formTemplate;
    @OneToOne(mappedBy = "formValue", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private SectionValue mainSectionValue;
}
