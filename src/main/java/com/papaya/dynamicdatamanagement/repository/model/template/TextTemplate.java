package com.papaya.dynamicdatamanagement.repository.model.template;

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
public class TextTemplate extends AbstractFormElementTemplate {
    @Column(columnDefinition="LONGTEXT")
    private String text;
}
