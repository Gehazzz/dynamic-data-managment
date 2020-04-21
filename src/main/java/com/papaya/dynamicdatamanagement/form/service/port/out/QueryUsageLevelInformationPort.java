package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.usage.CountryInfo;
import com.papaya.dynamicdatamanagement.form.usage.OrganisationInfo;
import com.papaya.dynamicdatamanagement.form.usage.ProjectInfo;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelRole;

import java.util.List;

public interface QueryUsageLevelInformationPort {
    List<OrganisationInfo> getAllOrganisations();

    List<OrganisationInfo> getAllOrganisationsByCountry(String countryId);

    List<ProjectInfo> getAllProjects();

    List<ProjectInfo> getAllProjectsByOrganisation(Long orgId);

    List<UsageLevelRole> getAllRoles();

    List<UsageLevelRole> getAllRolesByOrganisation(Long orgId);

    List<CountryInfo> getAllCountries();

    List<CountryInfo> getAllCountriesByOrganisation(Long orgId);
}
