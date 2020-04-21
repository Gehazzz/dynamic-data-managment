package com.papaya.dynamicdatamanagement.adapter.element;


import com.papaya.dynamicdatamanagement.form.usage.*;
import com.papaya.dynamicdatamanagement.repository.model.template.FormTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsageLevelAdapter {

    public UsageLevel calculateUsageLevelFromFormTemplate(FormTemplate formTemplate){
        UsageLevel usageLevel = new UsageLevel();
        List<Country> countries = formTemplate.getCountries();
        List<UsageLevelCountry> usageLevelCountries = getUsageLevelCountries(countries);
        usageLevel.setUsageLevelCountries(usageLevelCountries);

        List<Organisation> organisations = formTemplate.getOrganisations();
        List<UsageLevelOrganisation> usageLevelOrganisations = getUsageLevelOrganisations(organisations);
        usageLevel.setUsageLevelOrganisations(usageLevelOrganisations);

        List<Project> projects = formTemplate.getProjects();
        List<UsageLevelProject> usageLevelProjects = getUsageLevelProjects(projects);
        usageLevel.setUsageLevelProjects(usageLevelProjects);
        List<User> users = formTemplate.getUsers();
        List<UsageLevelRole> usageLevelRoles = getUsageLevelUsers(users);
        usageLevel.setUsageLevelRoles(usageLevelRoles);
        return usageLevel;
    }

    public List<UsageLevelRole> getUsageLevelUsers(List<User> users) {
        List<UsageLevelRole> usageLevelRoles = new ArrayList<>();
        if(users!=null && !users.isEmpty()){
            for (User user : users) {
                usageLevelRoles.add(UsageLevelRole.builder()
                        .userId(user.getId())
                        .userName(user.getName())
                        .build());
            }
        }
        return usageLevelRoles;
    }

    public List<User> getUsersFromUsageLevelUsers(List<UsageLevelRole> usageLevelRoles){
        List<User> users = new ArrayList<>();
        if(usageLevelRoles !=null && !usageLevelRoles.isEmpty()){
            for (UsageLevelRole usageLevelRole : usageLevelRoles) {
                users.add(User.builder()
                        .id(usageLevelRole.getUserId())
                        .name(usageLevelRole.getUserName())
                        .build());
            }
        }
        return users;
    }

    public List<UsageLevelProject> getUsageLevelProjects(List<Project> projects) {
        List<UsageLevelProject> usageLevelProjects = new ArrayList<>();
        if(projects!=null && !projects.isEmpty()){
            for (Project project : projects) {
                usageLevelProjects.add(UsageLevelProject.builder()
                        .projectId(project.getId())
                        .projectName(project.getName())
                        .build());
            }
        }
        return usageLevelProjects;
    }

    public List<Project> getProjectsFromUsageLevelProjects(List<UsageLevelProject> usageLevelProjects) {
        List<Project> projects = new ArrayList<>();
        if(usageLevelProjects!=null && !usageLevelProjects.isEmpty()){
            for (UsageLevelProject project : usageLevelProjects) {
                projects.add(Project.builder()
                        .id(project.getProjectId())
                        .name(project.getProjectName())
                        .build());
            }
        }
        return projects;
    }

    public List<UsageLevelOrganisation> getUsageLevelOrganisations(List<Organisation> organisations) {
        List<UsageLevelOrganisation> usageLevelOrganisations = new ArrayList<>();
        if(organisations!=null&&!organisations.isEmpty()){
            for (Organisation organisation : organisations) {
                usageLevelOrganisations.add(UsageLevelOrganisation.builder()
                        .organisationId(organisation.getId())
                        .organisationName(organisation.getName())
                        .build());
            }
        }
        return usageLevelOrganisations;
    }

    public List<Organisation> getOrganizationsDataFromUsageLevelOrganizations(List<UsageLevelOrganisation> usageLevelOrganisations){
        List<Organisation> organisations = new ArrayList<>();
        if(usageLevelOrganisations!=null&&!usageLevelOrganisations.isEmpty()){
            for (UsageLevelOrganisation usageLevelOrganisation : usageLevelOrganisations) {
                organisations.add(Organisation.builder()
                        .id(usageLevelOrganisation.getOrganisationId())
                        .name(usageLevelOrganisation.getOrganisationName())
                        .build());
            }
        }
        return organisations;
    }

    public List<UsageLevelCountry> getUsageLevelCountries(List<Country> countries) {
        List<UsageLevelCountry> usageLevelCountries = new ArrayList<>();
        if(countries!=null && !countries.isEmpty()){
            for (Country country : countries) {
                usageLevelCountries.add(UsageLevelCountry.builder()
                        .countryId(country.getId())
                        .countryName(country.getName())
                        .build());
            }
        }
        return usageLevelCountries;
    }

    public List<Country> getCountriesFromUsageLevelCountries(List<UsageLevelCountry> usageLevelCountries){
        List<Country> countries = new ArrayList<>();
        if(usageLevelCountries!=null && !usageLevelCountries.isEmpty()){
            for (UsageLevelCountry usageLevelCountry : usageLevelCountries) {
                countries.add(Country.builder()
                        .id(usageLevelCountry.getCountryId())
                        .name(usageLevelCountry.getCountryName())
                        .build());
            }
        }
        return countries;
    }
    
    
}
