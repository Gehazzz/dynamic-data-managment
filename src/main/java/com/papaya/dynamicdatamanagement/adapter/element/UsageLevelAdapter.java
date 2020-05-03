package com.papaya.dynamicdatamanagement.adapter.element;


import com.papaya.dynamicdatamanagement.form.usage.*;
import com.papaya.dynamicdatamanagement.repository.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsageLevelAdapter {

    public List<UsageLevel> getUsageLevelsFromFormUsageSet(Set<FormUsage> formUsages){
        return formUsages.stream().map(formUsage -> UsageLevel.builder()
                .countryIso(formUsage.getCountryIso())
                .organisationId(formUsage.getOrganisationId())
                .projectId(formUsage.getProjectId())
                .usageLevelRoles(formUsage.getUsers().stream().map(user -> UsageLevelUser.builder().id(user.getId()).userName(user.getUserName()).build()).collect(Collectors.toList())).build()
        ).collect(Collectors.toList());
    }


    public Set<FormUsage> getFormUsageSetFromUsageLevel(Set<UsageLevel> usageLevels){
       return usageLevels.stream().map(usageLevel -> FormUsage.builder()
                .countryIso(usageLevel.getCountryIso())
                .organisationId(usageLevel.getOrganisationId())
                .projectId(usageLevel.getProjectId())
                .users(usageLevel.getUsageLevelRoles().stream().map(usageLevelUser -> User.builder().id(usageLevelUser.getId()).userName(usageLevelUser.getUserName()).email(usageLevelUser.getEmail()).build()).collect(Collectors.toSet()))
                .build()
        ).collect(Collectors.toSet());
    }

    public CountryInfo getCountryInfo(Country country){
        return CountryInfo.builder()
                .countryId(country.getId())
                .countryName(country.getName()).build();
    }

    public OrganisationInfo getOrganisationInfo(Organisation organisation){
        return OrganisationInfo.builder()
                .countryInfo(getCountryInfo(organisation.getCountry()))
                .organisationId(organisation.getId())
                .organisationName(organisation.getName())
                .build();
    }

    public ProjectInfo getProjectInfo(Project project){
        return ProjectInfo.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .build();
    }

    public UsageLevelUser getUsageLevelUser(User user){
        return UsageLevelUser.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
    }

    public User getRole(UsageLevelUser usageLevelUser){
        return User.builder().id(usageLevelUser.getId()).userName(usageLevelUser.getUserName()).email(usageLevelUser.getEmail()).build();
    }

    
}
