package com.papaya.dynamicdatamanagement.data_model;

import com.papaya.dynamicdatamanagement.data_model.template.value.Value;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplementaryWorkerInformation {
    @Id
    @GeneratedValue
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
    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable(name = "supplementary_worker_information_value",
            joinColumns = @JoinColumn(name = "supplementary_worker_information_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    private List<Value> values;
}
