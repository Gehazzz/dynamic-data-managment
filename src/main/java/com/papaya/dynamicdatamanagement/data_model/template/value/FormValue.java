package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.Form;
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
    private Form form;
    @OneToOne(mappedBy = "formValue", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private SectionValue mainSectionValue;
}
