package com.papaya.dynamicdatamanagement.adapter;

import com.papaya.dynamicdatamanagement.form.elements.main.FormSubType;
import com.papaya.dynamicdatamanagement.form.elements.main.FormType;
import com.papaya.dynamicdatamanagement.form.elements.main.Template;
import com.papaya.dynamicdatamanagement.form.service.port.in.FormManagerService;
import com.papaya.dynamicdatamanagement.form.service.port.out.QueryFormPort;
import com.papaya.dynamicdatamanagement.form.usage.*;
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
        public class QueryFormPortImpl implements QueryFormPort {


    @Autowired
    private FormTemplateRepository formTemplateRepository;

    @Autowired
    private SectionMapper sectionMapper;


    @Override
    public Form getForm(Long id) {
        return convertTemplateToForm(formTemplateRepository.findById(id).get());
    }

    @Override
    public Form getForm(Long id, FormSubType subType) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build())).get(0);
        return convertTemplateToForm(formTemplate);
    }

    @Override
    public Form getForm(Long id, FormType formType, FormSubType subType) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .formType(getFormTemplateType(formType))
                .id(id)
                .build())).get(0);
        return convertTemplateToForm(formTemplate);
    }

    @Override
    public Form getForm(Long id, String label, FormSubType subType) {
        FormTemplate formTemplate = formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .label(label)
                .build())).get(0);
        return convertTemplateToForm(formTemplate);
    }

    @Override
    public List<Form> getAllForms() {
        return formTemplateRepository.findAll().stream().map(this::convertTemplateToForm).collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormSubType subType) {
      return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build())).stream().map(this::convertTemplateToForm).collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormSubType formSubType, UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(getUsersFromUsageLevelUsers(usageLevel.getUsageLevelUsers()))
                .projects(getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(formSubType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(getUsersFromUsageLevelUsers(usageLevel.getUsageLevelUsers()))
                .projects(getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(getUsersFromUsageLevelUsers(usageLevel.getUsageLevelUsers()))
                .projects(getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .formType(getFormTemplateType(formType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType, UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(getUsersFromUsageLevelUsers(usageLevel.getUsageLevelUsers()))
                .projects(getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .formType(getFormTemplateType(formType))
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    @Override
    public List<Form> getAllForms(FormType formType, FormSubType subType, UsageLevel usageLevel, String label) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(getUsersFromUsageLevelUsers(usageLevel.getUsageLevelUsers()))
                .projects(getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .countries(getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .organisations(getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .formType(getFormTemplateType(formType))
                .label(label)
                .formTemplateSubType(getFormTemplateSubTypeFromFormSubType(subType))
                .build()))
                .stream()
                .map(this::convertTemplateToForm)
                .collect(Collectors.toList());
    }

    private Form convertTemplateToForm(FormTemplate formTemplate){
        return Form.builder()
                .id(formTemplate.getId())
                .formType(getFormType(formTemplate.getFormType()))
                .usageLevel(calculateUsageLevelFromFormTemplate(formTemplate))
                .mainSection(sectionMapper.getSectionFromTemplate(formTemplate.getMainSection())).build();
    }


    public List<FormType> getAvailableFormCreationTemplateTypes(UsageLevel usageLevel) {
        return formTemplateRepository.findAll(Example.of(FormTemplate.builder()
                .users(getUsersFromUsageLevelUsers(usageLevel.getUsageLevelUsers()))
                .projects(getProjectsFromUsageLevelProjects(usageLevel.getUsageLevelProjects()))
                .organisations(getOrganizationsDataFromUsageLevelOrganizations(usageLevel.getUsageLevelOrganisations()))
                .countries(getCountriesFromUsageLevelCountries(usageLevel.getUsageLevelCountries()))
                .build())).stream().map(formTemplate -> getFormType(formTemplate.getFormType())).collect(Collectors.toList());
    }

    FormTemplateType getFormTemplateType(FormType formType){
        if(FormType.DYNAMIC.equals(formType)){
            return FormTemplateType.DYNAMIC;
        }
        else if(FormType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formType)){
            return FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        else if(FormType.WORKER_ON_BOARDING.equals(formType)){
            return FormTemplateType.WORKER_ON_BOARDING;
        }
        else if(FormType.PAYMENT_TEMPLATE.equals(formType)){
            return FormTemplateType.PAYMENT_TEMPLATE;
        }
        return null;
    }



    FormType getFormType(FormTemplateType formTemplateType){
        if(FormTemplateType.DYNAMIC.equals(formTemplateType)){
            return FormType.DYNAMIC;
        }
        if(FormTemplateType.SUPPLEMENTARY_WORKER_INFORMATION.equals(formTemplateType)){
            return FormType.SUPPLEMENTARY_WORKER_INFORMATION;
        }
        else if(FormTemplateType.WORKER_ON_BOARDING.equals(formTemplateType)){
            return FormType.WORKER_ON_BOARDING;
        }
        else if(FormTemplateType.PAYMENT_TEMPLATE.equals(formTemplateType)){
            return FormType.PAYMENT_TEMPLATE;
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

    FormSubType getFormSubTypeFromFormTemplateSubType(FormTemplateSubType formTemplateSubType){
        if(FormTemplateSubType.CREATION_TEMPLATE.equals(formTemplateSubType)){
            return FormSubType.CREATION_TEMPLATE;
        }
        if(FormTemplateSubType.FORM.equals(formTemplateSubType)){
            return FormSubType.FORM;
        }
        if(FormTemplateSubType.TEMPLATE.equals(formTemplateSubType)){
            return FormSubType.TEMPLATE;
        }
        return null;
    }

    FormTemplateSubType getFormTemplateSubTypeFromFormSubType(FormSubType formSubType){
        if(FormSubType.CREATION_TEMPLATE.equals(formSubType)){
            return FormTemplateSubType.CREATION_TEMPLATE;
        }
        if(FormSubType.FORM.equals(formSubType)){
            return FormTemplateSubType.FORM;
        }
        if(FormSubType.TEMPLATE.equals(formSubType)){
            return FormTemplateSubType.TEMPLATE;
        }
        return null;
    }

}
