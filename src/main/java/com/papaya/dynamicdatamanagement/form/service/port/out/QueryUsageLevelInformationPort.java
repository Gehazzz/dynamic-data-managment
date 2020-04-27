package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.usage.CountryInfo;
import com.papaya.dynamicdatamanagement.form.usage.OrganisationInfo;
import com.papaya.dynamicdatamanagement.form.usage.ProjectInfo;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelUser;

import java.util.List;

public interface QueryUsageLevelInformationPort {
    List<OrganisationInfo> getAllOrganisations();

    List<OrganisationInfo> getAllOrganisationsByCountry(String countryId);

    List<ProjectInfo> getAllProjects();

    List<ProjectInfo> getAllProjectsByOrganisation(Long orgId);

    List<UsageLevelUser> getAllUsers();

/*    List<UsageLevelUser> getAllUsersByOrganisation(Long orgId);*/

    List<CountryInfo> getAllCountries();

    List<CountryInfo> getAllCountriesByOrganisation(Long orgId);
}
