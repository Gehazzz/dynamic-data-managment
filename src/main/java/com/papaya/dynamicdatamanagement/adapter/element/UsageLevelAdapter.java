package com.papaya.dynamicdatamanagement.adapter.element;


import com.papaya.dynamicdatamanagement.form.usage.*;
import com.papaya.dynamicdatamanagement.repository.model.owner.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsageLevelAdapter {

    public List<UsageLevel> getUsageLevelsFromFormUsageList(List<FormUsage> formUsages){
        return formUsages.stream().map(formUsage -> UsageLevel.builder()
                .countryIso(formUsage.getCountryIso())
                .organisationId(formUsage.getOrganisationId())
                .projectId(formUsage.getProjectId())
                .usageLevelRoles(formUsage.getRoles().stream().map(role -> UsageLevelRole.builder().roleId(role.getId()).roleName(role.getTitle()).build()).collect(Collectors.toList())).build()
        ).collect(Collectors.toList());
    }


    public List<FormUsage> getFormUsageListFromUsageLevel(List<UsageLevel> usageLevels){
       return usageLevels.stream().map(usageLevel -> FormUsage.builder()
                .countryIso(usageLevel.getCountryIso())
                .organisationId(usageLevel.getOrganisationId())
                .projectId(usageLevel.getProjectId())
                .roles(usageLevel.getUsageLevelRoles().stream().map(usageLevelRole -> Role.builder().id(usageLevelRole.getRoleId()).title(usageLevelRole.getRoleName()).build()).collect(Collectors.toList()))
                .build()
        ).collect(Collectors.toList());
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
                .usageLevelRoles(organisation.getRoles().stream().map(this::getUsageLevelRole).collect(Collectors.toList()))
                .build();
    }

    public ProjectInfo getProjectInfo(Project project){
        return ProjectInfo.builder()
                .projectId(project.getId())
                .projectName(project.getName())
                .build();
    }

    public UsageLevelRole getUsageLevelRole(Role role){
        return UsageLevelRole.builder()
                .roleName(role.getTitle())
                .roleId(role.getId())
                .build();
    }

    public Role getRole(UsageLevelRole usageLevelRole){
        return Role.builder().id(usageLevelRole.getRoleId()).title(usageLevelRole.getRoleName()).build();
    }

    
}
