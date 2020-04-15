package com.papaya.dynamicdatamanagement.form.model.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
//TODO Redesign and refactor
public class UsageLevel {
    List<UsageLevelCountry> usageLevelCountries;
    List<UsageLevelOrganisation> usageLevelOrganisations;
    List<UsageLevelProject> usageLevelProjects;
    List<UsageLevelUser> usageLevelUsers;
}
