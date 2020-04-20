package com.papaya.dynamicdatamanagement.adapter;

import com.papaya.dynamicdatamanagement.form.service.port.out.QueryUsageLevelInformationPort;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelCountry;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelOrganisation;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelProject;
import com.papaya.dynamicdatamanagement.form.usage.UsageLevelUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryUsageLevelInformationPortImpl implements QueryUsageLevelInformationPort {
    @Override
    public List<UsageLevelOrganisation> getAllOrganisations() {
        return null;
    }

    @Override
    public List<UsageLevelOrganisation> getAllOrganisationsByCountry(Long countryId) {
        return null;
    }

    @Override
    public List<UsageLevelProject> getAllProjects() {
        return null;
    }

    @Override
    public List<UsageLevelProject> getAllProjectsByOrganisation(Long orgId) {
        return null;
    }

    @Override
    public List<UsageLevelUser> getAllUsers() {
        return null;
    }

    @Override
    public List<UsageLevelUser> getAllUsersByOrganisation(Long orgId) {
        return null;
    }

    @Override
    public List<UsageLevelUser> getAllUsersByProject(Long projectId) {
        return null;
    }

    @Override
    public List<UsageLevelCountry> getAllCountries() {
        return null;
    }

    @Override
    public List<UsageLevelCountry> getAllCountriesByOrganisation(Long orgId) {
        return null;
    }
}
