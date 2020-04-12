package com.papaya.dynamicdatamanagement.data_model.template;

import com.papaya.dynamicdatamanagement.data_model.template.value.InputFieldValue;
import com.papaya.dynamicdatamanagement.data_model.template.value.TextAreaValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TextArea extends AbstractInputField {
    private String placeholder;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "text_area_id")
    private List<TextAreaValue> textAreaValues;
}
