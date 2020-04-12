package com.papaya.dynamicdatamanagement.data_model.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
public class Text extends AbstractFormElement {
    @Column(columnDefinition="LONGTEXT")
    private String text;
}
