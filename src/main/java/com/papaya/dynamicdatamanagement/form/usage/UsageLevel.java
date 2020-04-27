package com.papaya.dynamicdatamanagement.form.usage;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//TODO Redesign and refactor
public class UsageLevel {
    private String countryIso;
    private Long organisationId;
    private Long projectId;
    private List<UsageLevelUser> usageLevelRoles;
}

