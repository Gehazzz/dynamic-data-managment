package com.papaya.dynamicdatamanagement.form.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.util.Map;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class BoundedValue {
    private String name;
    private Map<String, BoundedValue> values;
}
