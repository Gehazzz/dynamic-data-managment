package com.papaya.dynamicdatamanagement.adapter;

import com.papaya.dynamicdatamanagement.adapter.element.UsageLevelAdapter;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryUsageLevelInformationPort;
import com.papaya.dynamicdatamanagement.form.usage.*;
import com.papaya.dynamicdatamanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryUsageLevelInformationPortImpl implements QueryUsageLevelInformationPort {


    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UsageLevelAdapter usageLevelAdapter;

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private OrganizationsRepository organizationsRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostConstruct
    public void init (){
        List<OrganisationInfo> ch = getAllOrganisationsByCountry("ch");
        System.out.println(ch);
    }

    @Override
    public List<OrganisationInfo> getAllOrganisations() {
       return organizationsRepository.findAll().stream().map(organisation -> usageLevelAdapter.getOrganisationInfo(organisation)).collect(Collectors.toList());
    }

    @Override
    public List<OrganisationInfo> getAllOrganisationsByCountry(String countryId) {
        return organizationsRepository.findAllByCountry_Id(countryId).stream().map(organisation -> usageLevelAdapter.getOrganisationInfo(organisation)).collect(Collectors.toList());
    }

    @Override
    public List<ProjectInfo> getAllProjects() {
        return projectsRepository.findAll().stream().map(project -> usageLevelAdapter.getProjectInfo(project)).collect(Collectors.toList());
    }

    @Override
    public List<ProjectInfo> getAllProjectsByOrganisation(Long orgId) {
        return projectsRepository.findAllByOrganisation_Id(orgId).stream().map(project -> usageLevelAdapter.getProjectInfo(project)).collect(Collectors.toList());
    }

    @Override
    public List<UsageLevelUser> getAllUsers() {
        return userRepository.findAll().stream().map(role -> usageLevelAdapter.getUsageLevelUser(role)).collect(Collectors.toList());
    }

    /*@Override
    public List<UsageLevelUser> getAllUsersByOrganisation(Long orgId) {
        return userRepository.findAll(Example.of(User.builder().organisations(List.of(Organisation.builder().id(orgId).build())).build())).stream().map(role -> usageLevelAdapter.getUsageLevelUser(role)).collect(Collectors.toList());
    }*/

    @Override
    public List<CountryInfo> getAllCountries() {
        return countryRepository.findAll().stream().map(country -> usageLevelAdapter.getCountryInfo(country)).collect(Collectors.toList());
    }

    @Override
    public List<CountryInfo> getAllCountriesByOrganisation(Long orgId) {
         return countryRepository.findAll().stream().map(country -> usageLevelAdapter.getCountryInfo(country)).collect(Collectors.toList());

    }
}
