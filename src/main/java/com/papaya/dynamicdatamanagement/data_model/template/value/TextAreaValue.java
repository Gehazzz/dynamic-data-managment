package com.papaya.dynamicdatamanagement.data_model.template.value;

import com.papaya.dynamicdatamanagement.data_model.template.InputJavaType;
import com.papaya.dynamicdatamanagement.data_model.template.TextArea;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextAreaValue {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private TextArea textArea;
    @Column(columnDefinition="LONGTEXT")
    private String value;
    private InputJavaType type;
}
