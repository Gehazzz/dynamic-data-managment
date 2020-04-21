package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.service.port.in.UsageLevelService;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryUsageLevelInformationPort;
import com.papaya.dynamicdatamanagement.form.usage.CountryInfo;
import com.papaya.dynamicdatamanagement.form.usage.OrganisationInfo;
import com.papaya.dynamicdatamanagement.form.usage.ProjectInfo;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsageLevelServiceImpl implements UsageLevelService {
    @Autowired
    QueryUsageLevelInformationPort queryUsageLevelInformationPort;

    @Override
    public List<OrganisationInfo> getAllOrganisations() {
        return queryUsageLevelInformationPort.getAllOrganisations();
    }

    @Override
    public List<OrganisationInfo> getAllOrganisationsByCountry(String countryId) {
        return queryUsageLevelInformationPort.getAllOrganisationsByCountry(countryId);
    }

    @Override
    public List<ProjectInfo> getAllProjects() {
        return queryUsageLevelInformationPort.getAllProjects();
    }

    @Override
    public List<ProjectInfo> getAllProjectsByOrganisation(Long orgId) {
        return queryUsageLevelInformationPort.getAllProjectsByOrganisation(orgId);
    }

    @Override
    public List<UsageLevelRole> getAllUsers() {
        return queryUsageLevelInformationPort.getAllRoles();
    }

    @Override
    public List<UsageLevelRole> getAllUsersByOrganisation(Long orgId) {
        return queryUsageLevelInformationPort.getAllRolesByOrganisation(orgId);
    }
    @Override
    public List<CountryInfo> getAllCountries() {
        return queryUsageLevelInformationPort.getAllCountries();
    }

    @Override
    public List<CountryInfo> getAllCountriesByOrganization(Long orgId) {
        return queryUsageLevelInformationPort.getAllCountriesByOrganisation(orgId);
    }
}
