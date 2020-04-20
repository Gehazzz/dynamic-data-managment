package com.papaya.dynamicdatamanagement.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UsageLevelCountryDTO {
    private long countryId;
    private String countryName;
    List<UsageLevelProjectDTO> usageLevelProjects;
}
