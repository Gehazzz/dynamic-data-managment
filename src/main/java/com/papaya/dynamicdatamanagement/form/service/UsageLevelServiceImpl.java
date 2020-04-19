package com.papaya.dynamicdatamanagement.form.service;

import com.papaya.dynamicdatamanagement.form.service.port.in.UsageLevelService;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryUsageLevelInformationPort;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelCountry;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelOrganisation;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelProject;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsageLevelServiceImpl implements UsageLevelService {
    @Autowired
    QueryUsageLevelInformationPort queryUsageLevelInformationPort;

    @Override
    public List<UsageLevelOrganisation> getAllOrganisations() {
        return queryUsageLevelInformationPort.getAllOrganisations();
    }

    @Override
    public List<UsageLevelOrganisation> getAllOrganisationsByCountry(Long countryId) {
        return queryUsageLevelInformationPort.getAllOrganisationsByCountry(countryId);
    }

    @Override
    public List<UsageLevelProject> getAllProjects() {
        return queryUsageLevelInformationPort.getAllProjects();
    }

    @Override
    public List<UsageLevelProject> getAllProjectsByOrganisation(Long orgId) {
        return queryUsageLevelInformationPort.getAllProjectsByOrganisation(orgId);
    }

    @Override
    public List<UsageLevelUser> getAllUsers() {
        return queryUsageLevelInformationPort.getAllUsers();
    }

    @Override
    public List<UsageLevelUser> getAllUsersByOrganisation(Long orgId) {
        return queryUsageLevelInformationPort.getAllUsersByOrganisation(orgId);
    }

    @Override
    public List<UsageLevelUser> getAllUsersByProject(Long projectId) {
        return queryUsageLevelInformationPort.getAllUsersByProject(projectId);
    }

    @Override
    public List<UsageLevelCountry> getAllCountries() {
        return queryUsageLevelInformationPort.getAllCountries();
    }

    @Override
    public List<UsageLevelCountry> getAllCountriesByOrganization(Long orgId) {
        return queryUsageLevelInformationPort.getAllCountriesByOrganisation(orgId);
    }
}
