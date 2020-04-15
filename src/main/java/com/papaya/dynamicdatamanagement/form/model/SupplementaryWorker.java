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
public class SupplementaryWorker {
    private Long id;
    private String firstName;
    private String lastName;
    private String primaryEmail;
    private String companyName;
    private String homeAddress;
    private String bankName;
    private String iban;
    private String swift;
    private int bankAccountNumber;
    private int bankCode;
    private String branchName;
    private int branchCode;
    private Map<String, BoundedValue> values;
}
