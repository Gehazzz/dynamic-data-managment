package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.usage.CountryInfo;
import com.papaya.dynamicdatamanagement.form.usage.OrganisationInfo;
import com.papaya.dynamicdatamanagement.form.usage.ProjectInfo;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelRole;

import java.util.List;

public interface UsageLevelService {
    List<OrganisationInfo> getAllOrganisations();

    List<OrganisationInfo> getAllOrganisationsByCountry(String countryId);

    List<ProjectInfo> getAllProjects();

    List<ProjectInfo> getAllProjectsByOrganisation(Long orgId);

    List<UsageLevelRole> getAllUsers();

    List<UsageLevelRole> getAllUsersByOrganisation(Long orgId);

    List<CountryInfo> getAllCountries();

    List<CountryInfo> getAllCountriesByOrganization(Long orgId);
}
