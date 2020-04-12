package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.InputField;
import com.papaya.dynamicdatamanagement.data_model.template.InputJavaType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputFieldValue {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private InputField inputField;
    private String value;
    private InputJavaType type;
}
