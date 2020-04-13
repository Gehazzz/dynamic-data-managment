package com.papaya.dynamicdatamanagement.data_model.template;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormTemplate {
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    //private FormType formType;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "form_id")
    private SectionTemplate mainSection;
}
