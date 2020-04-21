package com.papaya.dynamicdatamanagement.web.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsageLevelDTO {
    private String countryIso;
    private Long organisationId;
    private Long projectId;
    private List<RoleDTO> usageLevelRoles;
}
