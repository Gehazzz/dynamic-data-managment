package com.papaya.dynamicdatamanagement.form.usage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrganisationInfo {
    private long organisationId;
    private String organisationName;
    private CountryInfo countryInfo;
    private List<UsageLevelUser> usageLevelUsers;
}
