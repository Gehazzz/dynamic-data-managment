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
    List<UsageLevelCountry> usageLevelCountries;
    List<UsageLevelOrganisation> usageLevelOrganisations;
    List<UsageLevelProject> usageLevelProjects;
    List<UsageLevelUser> usageLevelUsers;
}
