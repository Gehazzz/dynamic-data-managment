package com.papaya.dynamicdatamanagement.form.service.port.out;

import com.papaya.dynamicdatamanagement.form.usage.UsageLevelCountry;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelOrganisation;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelProject;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelUser;

import java.util.List;

public interface QueryUsageLevelInformationPort {
    List<UsageLevelOrganisation> getAllOrganisations();
    List<UsageLevelProject> getAllProjects();
    List<UsageLevelProject> getAllProjectsByOrganisation();
    List<UsageLevelUser> getAllUsers();
    List<UsageLevelUser> getAllUsersByOrganisation();
    List<UsageLevelUser> getAllUsersByProject();
    List<UsageLevelCountry> getAllCountries();
}
