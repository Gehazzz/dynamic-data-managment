package com.papaya.dynamicdatamanagement.adapter;

import com.papaya.dynamicdatamanagement.adapter.element.UsageLevelAdapter;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryUsageLevelInformationPort;
import com.papaya.dynamicdatamanagement.form.usage.*;
import com.papaya.dynamicdatamanagement.repository.CountryRepository;
import com.papaya.dynamicdatamanagement.repository.OrganizationsRepository;
import com.papaya.dynamicdatamanagement.repository.ProjectsRepository;
import com.papaya.dynamicdatamanagement.repository.UsersRepository;
import com.papaya.dynamicdatamanagement.repository.model.owner.Country;
import com.papaya.dynamicdatamanagement.repository.model.owner.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class QueryUsageLevelInformationPortImpl implements QueryUsageLevelInformationPort {

    @Autowired
    private UsageLevelAdapter usageLevelAdapter;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private OrganizationsRepository organizationsRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostConstruct
    public void init (){
        List<UsageLevelOrganisation> ch = getAllOrganisationsByCountry("ch");
        System.out.println(ch);
    }

    @Override
    public List<UsageLevelOrganisation> getAllOrganisations() {
        List<Organisation> all = organizationsRepository.findAll();
        return usageLevelAdapter.getUsageLevelOrganisations(all);
    }

    @Override
    public List<UsageLevelOrganisation> getAllOrganisationsByCountry(String countryId) {
        List<Organisation> allByCountryId = organizationsRepository.findAll(countryId);
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
