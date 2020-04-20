package com.papaya.dynamicdatamanagement.form.service.port.in;

import com.papaya.dynamicdatamanagement.form.usage.UsageLevelCountry;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelOrganisation;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelProject;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelUser;

import java.util.List;

public interface UsageLevelService {
    List<UsageLevelOrganisation> getAllOrganisations();

    List<UsageLevelOrganisation> getAllOrganisationsByCountry(String countryId);

    List<UsageLevelProject> getAllProjects();

    List<UsageLevelProject> getAllProjectsByOrganisation(Long orgId);

    List<UsageLevelUser> getAllUsers();

    List<UsageLevelUser> getAllUsersByOrganisation(Long orgId);

    List<UsageLevelUser> getAllUsersByProject(Long projectId);

    List<UsageLevelCountry> getAllCountries();

    List<UsageLevelCountry> getAllCountriesByOrganization(Long orgId);
}