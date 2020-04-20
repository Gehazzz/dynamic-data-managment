package com.papaya.dynamicdatamanagement.web.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//TODO Redesign and refactor
public class UsageLevelDTO {
    List<UsageLevelCountryDTO> usageLevelCountries;
    List<UsageLevelOrganisationDTO> usageLevelOrganisations;
    List<UsageLevelProjectDTO> usageLevelProjects;
    List<UsageLevelUserDTO> usageLevelUsers;
}
