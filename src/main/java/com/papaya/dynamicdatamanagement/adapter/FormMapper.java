package com.papaya.dynamicdatamanagement.adapter;

import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormCreationTemplatePort;
import com.papaya.dynamicdatamanagement.form.usage.*;
import com.papaya.dynamicdatamanagement.form.validation.FormValidator;
import com.papaya.dynamicdatamanagement.repository.FormTemplateRepository;
import com.papaya.dynamicdatamanagement.repository.model.owner.Country;
import com.papaya.dynamicdatamanagement.repository.model.owner.Organisation;
import com.papaya.dynamicdatamanagement.repository.model.owner.Project;
import com.papaya.dynamicdatamanagement.repository.model.owner.User;
import com.papaya.dynamicdatamanagement.repository.model.template.*;
import com.papaya.dynamicdatamanagement.form.elements.main.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FormMapper implements QueryFormCreationTemplatePort {


    @Autowired
    private FormTemplateRepository formTemplateRepository;

    @Autowired
    private SectionMapper sectionMapper;


    @Override
    public Form getFormCreationTemplate(Long id) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .id(id)
                .build())).get(0);
        return convertTemplateToForm(formTemplate);
    }

    private Form convertTemplateToForm(FormTemplate formTemplate){
        return Form.builder()
                .id(formTemplate.getId())
                .formType(getFormType(formTemplate.getFormType()))
                .usageLevel(calculateUsageLevelFromFormTemplate(formTemplate))
                .mainSection(sectionMapper.getSectionFromTemplate(formTemplate.getMainSection())).build();
    }

    @Override
    public Form getFormCreationTemplate(String label, UsageLevel usageLevel) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .label(label)
                .users(getUsersFromUsageLevelUsers(usageLevel.getUsageLevelUsers()))
                .projects(getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .organisations(getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .countries(getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .build())).get(0);
        return convertTemplateToForm(formTemplate);
    }

    @Override
    public List<Form> getAllFormCreationTemplates() {
        return formTemplateRepository
                .findAll()
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<FormType> getAvailableFormCreationTemplateTypes(UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(getUsersFromUsageLevelUsers(usageLevel.getUsageLevelUsers()))
                .projects(getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .organisations(getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .countries(getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .build())).stream().map(formTemplate -> getFormType(formTemplate.getFormType())).collect(Collectors.toList());
    }

    FormTemplateType getFormTemplateType(FormType formType){
        if(FormType.DYNAMIC_CREATION_TEMPLATE.equals(formType)){
            return FormTemplateType.DYNAMIC_CREATION_TEMPLATE;
        }
        if(FormType.DYNAMIC.equals(formType)){
            return FormTemplateType.DYNAMIC;
        }
        if(FormType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE.equals(formType)){
            return FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE;
        }
        if(FormType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formType)){
            return FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        return null;
    }



    FormType getFormType(FormTemplateType formTemplateType){
        if(FormTemplateType.DYNAMIC_CREATION_TEMPLATE.equals(formTemplateType)){
            return FormType.DYNAMIC_CREATION_TEMPLATE;
        }
        if(FormTemplateType.DYNAMIC.equals(formTemplateType)){
            return FormType.DYNAMIC;
        }
        if(FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE.equals(formTemplateType)){
            return FormType.SUPPLEMENTARY_WORKER_INFORMATION_CREATION_TEMPLATE;
        }
        if(FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formTemplateType)){
            return FormType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        return null;
    }

    UsageLevel calculateUsageLevelFromFormTemplate(FormTemplate formTemplate){
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
        List<UsageLevelUser> usageLevelUsers = getUsageLevelUsers(users);
        usageLevel.setUsageLevelUsers(usageLevelUsers);
        return usageLevel;
    }

    private List<UsageLevelUser> getUsageLevelUsers(List<User> users) {
        List<UsageLevelUser> usageLevelUsers = new ArrayList<>();
        if(users!=null && !users.isEmpty()){
            for (User user : users) {
                usageLevelUsers.add(UsageLevelUser.builder()
                        .userId(user.getId())
                        .userName(user.getName())
                        .build());
            }
        }
        return usageLevelUsers;
    }

    private List<User> getUsersFromUsageLevelUsers(List<UsageLevelUser> usageLevelUsers){
        List<User> users = new ArrayList<>();
        if(usageLevelUsers!=null && !usageLevelUsers.isEmpty()){
            for (UsageLevelUser usageLevelUser : usageLevelUsers) {
                users.add(User.builder()
                        .id(usageLevelUser.getUserId())
                        .name(usageLevelUser.getUserName())
                        .build());
            }
        }
        return users;
    }

    private List<UsageLevelProject> getUsageLevelProjects(List<Project> projects) {
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

    private List<Project> getProjectsFromUsageLevelProjects(List<UsageLevelProject> usageLevelProjects) {
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

    private List<UsageLevelOrganisation> getUsageLevelOrganisations(List<Organisation> organisations) {
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

    private List<Organisation> getOrganizationsDataFromUsageLevelOrganizations(List<UsageLevelOrganisation> usageLevelOrganisations){
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

    private List<UsageLevelCountry> getUsageLevelCountries(List<Country> countries) {
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

    private List<Country> getCountriesFromUsageLevelCountries(List<UsageLevelCountry> usageLevelCountries){
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
