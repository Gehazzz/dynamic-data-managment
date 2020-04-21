package com.papaya.dynamicdatamanagement.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class SearchRoleDto {
    private String countryIso;
    private Long organisationId;
    private Long projectId;
}
